package com.nepalaya.up.repository;

import com.nepalaya.up.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByEmailAddressAndPassword(String emailAddress, String password);

    @Query(value = "select * from users u where u.reset_token = ?1",nativeQuery = true)
    Optional<User> findByResetToken(String token);
}
