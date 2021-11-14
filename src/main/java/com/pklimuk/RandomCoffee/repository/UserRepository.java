package com.pklimuk.RandomCoffee.repository;

import com.pklimuk.RandomCoffee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
