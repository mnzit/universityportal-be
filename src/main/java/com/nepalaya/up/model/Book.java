package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.BookState;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_BOOKS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity<User> {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_DETAIL_ID", referencedColumnName = "ID")
    private BookDetail bookDetail;

    @Column(name = "STATE", columnDefinition = "enum('TAKEN','STOLEN', 'AVAILABLE', 'DAMAGED', 'LOST', 'NEW') DEFAULT 'NEW'")
    @Enumerated(EnumType.STRING)
    private BookState state;

    public Book(Long id) {
        super(id);
    }
}
