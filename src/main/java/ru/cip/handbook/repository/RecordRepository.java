package ru.cip.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.cip.handbook.entity.Record;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {
    public Record getById(Integer id);

    @Query("select r from Record r where " +
            "r.name like %:search% or " +
            "r.vkRef like %:search% or " +
            "r.fbRef like %:search% or " +
            "r.skype like %:search% or " +
            "r.whatsapp like %:search% or " +
            "r.telegram like %:search%")
    public List<Record> findByField(@Param("search") String search);
}
