package com.nepalaya.up.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ROLE_AUTHORITIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthority extends BaseEntity<User> {

    @Basic(optional = true)
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private Role role;

    @Basic(optional = true)
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")
    private Authority authority;

}