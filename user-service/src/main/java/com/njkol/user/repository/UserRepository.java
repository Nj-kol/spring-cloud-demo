package com.njkol.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njkol.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

	User findByFirstName(String firstName);
}
