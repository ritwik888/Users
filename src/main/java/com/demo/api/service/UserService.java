package com.demo.api.service;

import java.util.Map;

import com.demo.api.model.User;

public interface UserService {
	public User createUser(User us);
	public User getUser(String userId);
	public User deleteUser(String userId);
	public User putUser(String userId, User us);
	public Map<String,User> getAllUser();
}
