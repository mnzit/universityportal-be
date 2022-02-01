package com.nepalaya.up.repository;

import com.nepalaya.up.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Optional<User> findByEmailAddress(String emailAddress);
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Optional<User> findByEmailAddressAndPassword(String emailAddress, String password);
}
