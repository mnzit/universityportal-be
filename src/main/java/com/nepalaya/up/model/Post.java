package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "POSTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity<User> {

    @Column(length = 150, name = "TITLE", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", name = "DESCRIPTION", nullable = false)
    private String description;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<PostComment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<PostFiles> files;

}