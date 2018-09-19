package com.njkol.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njkol.user.model.User;
import com.njkol.user.repository.UserRepository;

/**
 * Implementation of User CRUD service
 * 
 * @author Nilanjan Sarkar
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository repo;

	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	public void addUser(User p) throws Exception {
		repo.save(p);
	}

	public void updateUser(User p) throws Exception {
		repo.save(p);
	}

	public User getUser(int UserID) throws Exception {
		return repo.findOne(UserID);
	}

	public void deleteUser(int UserID) throws Exception {
		repo.delete(UserID);
	}

	public User getUserByName(String name) {
		return repo.findByFirstName(name);
	}
}
