package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BOOK_DETAILS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "book_details", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class BookDetail extends BaseEntity<User> {

    @Column(length = 100, name = "TITLE", nullable = false)
    private String title;

    @Column(length = 150, name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "PUBLISHED_DATE", nullable = false)
    private Date publishedDate;

    @Column(name = "ISBN", nullable = false)
    private Long isbn;

    @JsonIgnore
    @OneToMany(mappedBy = "bookDetail", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Book> books;

    public BookDetail(Long id) {
        super(id);
    }
}
