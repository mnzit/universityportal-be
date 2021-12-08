package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BOOKS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity<User> {

    @JsonBackReference
    @NotBlank
    @Size(min = 2, max = 150)
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "BOOK_DETAIL_ID", referencedColumnName = "ID")
    private BookDetail bookDetail;

    @Basic(optional = true)
    @Column(name = "STATE", columnDefinition = "enum('TAKEN','STOLEN', 'AVAILABLE', 'DAMAGED', 'LOST') DEFAULT 'AVAILABLE'")
    @Enumerated(EnumType.STRING)
    private BookStatus state;
}
