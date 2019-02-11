package ru.cip.handbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cip.handbook.entity.Record;
import ru.cip.handbook.repository.RecordRepository;

import java.util.List;

@Service
public class MainService {

    @Autowired
    RecordRepository recordRepository;

    public void save(Record record) {
        recordRepository.save(record);
    }

    public void update(Record record) {
        recordRepository.save(record);
    }

    public void delete(Integer id) {
        recordRepository.delete(recordRepository.getById(id));
    }

    public Record getById(Integer id) {
        return recordRepository.getById(id);
    }

    public List<Record> getAll() {
        return recordRepository.findAll();
    }

    public List<Record> find(String searchField) {
        return recordRepository.findByField(searchField);
    }
}
