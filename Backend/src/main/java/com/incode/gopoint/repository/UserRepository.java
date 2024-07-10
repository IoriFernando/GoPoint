package com.incode.gopoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incode.gopoint.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}