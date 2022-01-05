package com.nepalaya.up.repository;


import com.nepalaya.up.model.BookDetail;
import com.nepalaya.up.model.BookHistory;
import com.nepalaya.up.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookHistoryRepository extends JpaRepository<BookHistory, Long> {

    @Query("SELECT bh FROM BookHistory bh WHERE bh.id = :id")
    List<BookHistory> findBookHistoriesByBook(Long id);

    @Query("select bh from BookHistory bh where bh.book.bookDetail = :bookDetail and bh.user= :user and bh.book.state ='TAKEN'")
    BookHistory findBorrowedBook(@Param("bookDetail") BookDetail bookDetail, @Param("user") User user);
}
