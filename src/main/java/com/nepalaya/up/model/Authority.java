package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "AUTHORITIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "NAME", nullable = false)
    private String name;
}
