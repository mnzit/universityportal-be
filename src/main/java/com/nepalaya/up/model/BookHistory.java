package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "BOOK_HISTORIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookHistory extends BaseEntity<User> {

    @NotBlank
    @Size(min = 2, max = 150)
    @OneToOne
    @Basic(optional = false)
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    private Book book;

    @NotBlank
    @Size(min = 2, max = 150)
    @OneToOne
    @Basic(optional = false)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "BOOK_TAKEN_DATE", nullable = false)
    private Date bookTakenDate;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "BOOK_RETURNED_DATE", nullable = false)
    private Date bookReturnedDate;

    public BookHistory(Long id) {
        super(id);
    }
}
