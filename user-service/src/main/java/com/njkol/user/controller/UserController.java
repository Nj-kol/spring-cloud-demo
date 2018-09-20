package com.njkol.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.njkol.user.model.User;
import com.njkol.user.service.UserService;

import org.apache.log4j.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for User service
 * 
 * @author Nilanjan Sarkar
 *
 */
@Api(value = "User Service")
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = Logger.getLogger(UserController.class);

	@Value("${message}")
	private String myMessage;

	@Autowired
	private UserService service;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Creates a User")
	public void create(@RequestBody User book) throws Exception {
		logger.info("Creating new user");
		service.addUser(book);
	}

	@GetMapping("/getbyname/{name}")
	@ApiOperation(value = "Retrives a User by their first name")
	public User getUserByName(@PathVariable String name) throws Exception {
		logger.info("Fetching user " + name + " details");
		return service.getUserByName(name);
	}

	@GetMapping("/getbyid/{id}")
	@ApiOperation(value = "Retrives a User by their first id")
	public User getUserById(@PathVariable int id) throws Exception {
		logger.info("Fetching user Id : " + id + " details");
		logger.info("The message from the config server is : " + myMessage);
		return service.getUser(id);
	}

	@ApiOperation(value = "Deletes a User by their id")
	@HystrixCommand(fallbackMethod = "deleteUserByIDFallback")
	@DeleteMapping("/delete/{id}")
	public String deleteUserByID(@PathVariable int id) throws Exception {
		logger.info("Deleting user Id: " + id);
		service.deleteUser(id);
		return "User deleted successfully!";
	}

	/**
	 * Fallback method when database is offline
	 */
	public String deleteUserByIDFallback(int i) {
		return "Database down, please try again after sometime";
	}
}
