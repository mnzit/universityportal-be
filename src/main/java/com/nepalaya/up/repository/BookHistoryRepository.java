package com.nepalaya.up.repository;


import com.nepalaya.up.model.BookHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookHistoryRepository extends JpaRepository<BookHistory, Long> {

    @Query("SELECT bh FROM BookHistory bh WHERE bh.id = :id")
    List<BookHistory> findBookHistoriesByBook(Long id);
}
