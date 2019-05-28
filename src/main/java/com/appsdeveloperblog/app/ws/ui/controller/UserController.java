package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {

//	@GetMapping(path="/{userId}")
//	public String getUser(@PathVariable String userId) {
	
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort",  defaultValue="desc", required = false) String sort) {
		return "get user called page = " + page + " limit " + limit + " sort: " + sort;
	}
	
	@GetMapping(path="/{userId}")
	public UserRest getUser(@PathVariable String userId) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail("test@test.com");
		returnValue.setFirstName("David");
		returnValue.setLastName("Lee");
		return returnValue;
	}
	
	@PostMapping
	public String createUser() {
		return "create user called";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user called";
	}	
}
