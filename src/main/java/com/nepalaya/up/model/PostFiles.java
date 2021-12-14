package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "POSTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFiles extends BaseEntity<User> {

    @JsonBackReference
    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @ManyToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 1000)
    @ManyToOne
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    private File file;

}