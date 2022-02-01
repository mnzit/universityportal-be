package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "POSTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(region = "post_files", usage = CacheConcurrencyStrategy.READ_WRITE)
public class PostFiles extends BaseEntity<User> {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    private File file;

}