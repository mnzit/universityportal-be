package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "ROLE_AUTHORITIES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "role_authorities", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class RoleAuthority extends BaseEntity<User> {

    @JsonBackReference
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Authority authority;

}