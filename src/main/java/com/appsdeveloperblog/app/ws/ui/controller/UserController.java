package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String, UserRest> users;
	

//	@GetMapping(path="/{userId}")
//	public String getUser(@PathVariable String userId) {
	
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort",  defaultValue="desc", required = false) String sort) {
		return "get user called page = " + page + " limit " + limit + " sort: " + sort;
	}
	
//	@GetMapping(path="/{userId}")
//	public UserRest getUser(@PathVariable String userId) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail("test@test.com");
//		returnValue.setFirstName("David");
//		returnValue.setLastName("Lee");
//		return returnValue;
//	}
	
//	@GetMapping(path="/{userId}", produces = { 
//			MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_VALUE})
//	public UserRest getUser(@PathVariable String userId) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail("test@test.com");
//		returnValue.setFirstName("David");
//		returnValue.setLastName("Lee");
//		return returnValue;
//	}
	
//	@GetMapping(path="/{userId}", produces = { 
//			MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail("test@test.com");
//		returnValue.setFirstName("David");
//		returnValue.setLastName("Lee");
//		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
////		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
//	}
	
	//create
	//http://localhost:8080/users
	//{
//	"firstName": "Melinda",
//	"lastName": "Gates",
//	"email": "bill@ms.com",
//	"password": "123"
//}
	//accept Content-Type application/json 
//	@PostMapping(consumes = { 
//				MediaType.APPLICATION_XML_VALUE,
//				MediaType.APPLICATION_JSON_VALUE},
//			produces = { 
//				MediaType.APPLICATION_XML_VALUE,
//				MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail(userDetails.getEmail());
//		returnValue.setFirstName(userDetails.getFirstName());
//		returnValue.setLastName(userDetails.getLastName());
//		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
//	}
//	
	
	
	@GetMapping(path="/{userId}", produces = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},
		produces = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		if(users == null) {
			users = new HashMap<>();
		}
		users.put(userId, returnValue);
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	
	//create first
	//then update http://localhost:8080/users/9890e3b5-424f-4d16-b5d4-5d6256f066c1
	@PutMapping(path="/{userId}", consumes = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},
		produces = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storeUserDetails = users.get(userId);
		storeUserDetails.setFirstName(userDetails.getFirstName());
		storeUserDetails.setLastName(userDetails.getLastName());
		users.put(userId, storeUserDetails);
		return storeUserDetails;
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user called";
	}	
}
