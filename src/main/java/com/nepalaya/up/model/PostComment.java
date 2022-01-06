package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TBL_POST_COMMENTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostComment extends BaseEntity<User> {

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @NotBlank
    @Column(columnDefinition = "TEXT", name = "DESCRIPTION", nullable = false)
    private String description;
}