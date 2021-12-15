package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ROLES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "NAME", nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<RoleAuthority> roleAuthorities;

//    @ManyToMany
//    @JoinTable(
//            name = "ROLE_AUTHORITIES",
//            joinColumns = @JoinColumn(name = "ROLE_ID"),
//            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID"))
//    private List<Authority> authorities;
}
