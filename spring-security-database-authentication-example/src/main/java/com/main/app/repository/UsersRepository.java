package com.main.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUsernameOrEmail(String username, String email);
}
