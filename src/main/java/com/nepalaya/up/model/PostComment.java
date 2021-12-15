package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "POST_COMMENTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostComment extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 1000)
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
}