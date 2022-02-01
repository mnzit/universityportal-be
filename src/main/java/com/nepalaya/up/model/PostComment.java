package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "POST_COMMENTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "post_comments", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class PostComment extends BaseEntity<User> {

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @NotBlank
    @Column(columnDefinition = "TEXT", name = "DESCRIPTION", nullable = false)
    private String description;
}