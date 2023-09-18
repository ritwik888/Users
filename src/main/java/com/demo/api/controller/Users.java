package com.demo.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.demo.api.model.User;
import com.demo.api.service.UserService;

@RestController
@RequestMapping("users")
public class Users {
	
	@Autowired
	UserService service;
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User us = service.getUser(userId);
		if(us != null) {
			return new ResponseEntity<User>(us,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<Map<String,User>> getUsers(@RequestParam(value="page", defaultValue="1", required=false) int page,
							@RequestParam(value="limit", defaultValue="10", required=false) int limit,
							@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		Map<String,User> allUser = service.getAllUser();
		return new ResponseEntity<Map<String,User>>(allUser,HttpStatus.OK);
	}
	
	@PostMapping(consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.ALL_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> postUser(@RequestBody User us) {
		User newUser = service.createUser(us);
		return new ResponseEntity<User>(newUser,HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}"
			,consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.ALL_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> putUser(@PathVariable String userId,@RequestBody User us) {
		User us2 = service.putUser(userId, us);
		if(us2 == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);			
		}else {
			return new ResponseEntity<User>(us2,HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) {
		User us = service.deleteUser(userId);
		if(us != null) {
			return new ResponseEntity<User>(us,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

}
