package com.nepalaya.up.repository;


import com.nepalaya.up.model.BookRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRecordRepository extends JpaRepository<BookRecord, Long> {
}
