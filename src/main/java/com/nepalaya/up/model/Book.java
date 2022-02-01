package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.BookState;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "books", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Book extends BaseEntity<User> {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_DETAIL_ID", referencedColumnName = "ID")
    private BookDetail bookDetail;

    @Column(name = "STATE", columnDefinition = "VARCHAR(100) DEFAULT 'NEW'")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Enumerated(EnumType.STRING)
    private BookState state;

    public Book(Long id) {
        super(id);
    }
}
