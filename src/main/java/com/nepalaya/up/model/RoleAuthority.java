package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ROLE_AUTHORITIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthority extends BaseEntity<User> {

    @JsonBackReference
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Role.class)
    private Role role;

    @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Authority.class)
    private Authority authority;

}