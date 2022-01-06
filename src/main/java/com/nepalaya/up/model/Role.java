package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_ROLES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<User> {

    @Column(length = 150, name = "NAME", nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<RoleAuthority> roleAuthorities;

    public Role(Long id) {
        super(id);
    }
}
