package com.nepalaya.up.repository;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.bookDetail = :bookDetail and b.state='AVAILABLE'")
    List<Book> getAvailableBooks(@Param("bookDetail") BookDetail bookDetail);

}
