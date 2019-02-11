package ru.cip.handbook.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.cip.handbook.entity.Phone;
import ru.cip.handbook.entity.Record;
import ru.cip.handbook.repository.RecordRepository;
import ru.cip.handbook.service.MainService;

import java.util.HashSet;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping("/")
    public String allGet(Model model) {
        model.addAttribute("records", service.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String createGet(Model model) {
        model.addAttribute("record", new Record());
        return "create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute(name = "record") Record record, @RequestParam(name = "type") String type, @RequestParam(name = "number") String number) {

        HashSet<Phone> phones = new HashSet<>();
        Phone phone = new Phone(type, number);
        phone.setRecord(record);
        phones.add(phone);
        record.setPhones(phones);

        service.save(record);

        return "redirect:";
    }

    @GetMapping("/update")
    public String updateGet(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("record", service.getById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute(name = "record") Record record, @RequestParam(name = "type") String type, @RequestParam(name = "number") String number) {

        HashSet<Phone> phones = new HashSet<>();
        Phone phone = new Phone(type, number);
        phone.setRecord(record);
        phones.add(phone);
        record.setPhones(phones);

        service.update(record);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) {
        service.delete(id);
        return "redirect:";
    }

    @PostMapping("/findRecord")
    public String find(@RequestParam(name = "searchField") String searchField, Model model) {
        model.addAttribute("records", service.find(searchField));
        return "index";
    }
}
