package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nepalaya.up.model.enums.GenderType;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<User> implements UserDetails {

    @Column(length = 150, name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(length = 150, name = "MIDDLENAME")
    private String middleName;

    @Column(length = 150, name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @Column(length = 150, name = "ADDRESS", nullable = false)
    private String address;

    @JsonIgnore
    @Column(length = 20, name = "CONTACT_NO", nullable = false)
    private String contactNo;

    @JsonIgnore
    @Column(length = 150, name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @JsonIgnore
    @Column(length = 150, name = "PASSWORD", nullable = false)
    private String password;

    @JsonIgnore
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role
                .getRoleAuthorities()
                .stream()
                .map(roleAuthority -> new SimpleGrantedAuthority(roleAuthority.getAuthority().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    public List<String> authorities() {
        return role
                .getRoleAuthorities()
                .stream()
                .map(roleAuthority -> roleAuthority.getAuthority().getName())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isEnabled() {
        return getStatus();
    }

    public String getFullName(){
        StringBuilder fullName = new StringBuilder();
        if(firstName != null){
            fullName.append(firstName);
            fullName.append(" ");
        }
        if(middleName != null){
            fullName.append(middleName);
            fullName.append(" ");
        }
        if(lastName != null){
            fullName.append(lastName);
        }
        return fullName.toString();
    }
}
