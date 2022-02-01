package com.nepalaya.up.repository;

import com.nepalaya.up.model.Book;
import com.nepalaya.up.model.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT b FROM Book b WHERE b.bookDetail = :bookDetail AND b.state='AVAILABLE' OR b.state = 'NEW' AND b.status = true")
    List<Book> getAvailableBooks(@Param("bookDetail") BookDetail bookDetail);
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT b FROM Book b WHERE b.id = :bookId AND b.state='AVAILABLE' OR b.state = 'NEW' AND b.status = true")
    Book getBorrowableBook(@Param("bookId") Long bookId);

}
