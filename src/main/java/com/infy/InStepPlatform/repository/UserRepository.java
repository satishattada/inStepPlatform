package com.infy.InStepPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.InStepPlatform.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String>{

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
