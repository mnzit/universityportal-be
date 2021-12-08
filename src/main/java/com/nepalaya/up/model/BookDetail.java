package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BOOK_DETAILS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetail extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "PUBLISHED_DATE", nullable = false)
    private Date publishedDate;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "ISBN", nullable = false)
    private Long isbn;

    @OneToMany(mappedBy = "bookDetail", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Book> books;

}
