package com.demo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

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

import com.demo.api.payload.UserDto;
import com.demo.api.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
		LOGGER.info("Getting user for id {}",userId);
		UserDto us = service.getUser(userId);
		LOGGER.info("User with id {} found, returning OK",userId);
		return new ResponseEntity<UserDto>(us,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers(@RequestParam(value="page", defaultValue="1", required=false) int page,
							@RequestParam(value="limit", defaultValue="10", required=false) int limit,
							@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		LOGGER.info("Getting all user for page {}, limit {} and sort {}",page,limit,sort);
		List<UserDto> allUser = service.getAllUser();
		LOGGER.info("Returning list of size {} for page {}, limit {} and sort {}",allUser.size(),page,limit,sort);
		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
	}
	
	@PostMapping(consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.ALL_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserDto> postUser(@RequestBody UserDto us) {
		LOGGER.info("Creating new user for {}",us);
		UserDto newUser = service.createUser(us);
		LOGGER.info("Created new user with id {}",newUser.getId());
		return new ResponseEntity<UserDto>(newUser,HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}"
			,consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.ALL_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserDto> putUser(@PathVariable Integer userId,@RequestBody UserDto us) {
		UserDto us2 = service.putUser(userId, us);
		return new ResponseEntity<UserDto>(us2,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId) {
		UserDto us = service.deleteUser(userId);
		return new ResponseEntity<UserDto>(us,HttpStatus.OK);
	}

}
