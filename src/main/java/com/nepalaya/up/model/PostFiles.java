package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFiles extends BaseEntity<User> {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    private File file;

}