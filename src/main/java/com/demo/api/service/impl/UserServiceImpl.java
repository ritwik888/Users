package com.demo.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.model.User;
import com.demo.api.service.UserService;
import com.demo.api.utill.UserUtill;

@Service
public class UserServiceImpl implements UserService{
	
	Map<String,User> userMap;
	UserUtill utill;
	
	@Autowired
	public UserServiceImpl(UserUtill utill) {
		this.utill = utill;
	}

	@Override
	public User createUser(User us) {
		User newUser = new User();
		newUser.setName(us.getName());
		newUser.setEmail(us.getEmail());
		String id = utill.generateRandomId();
		newUser.setId(id);
		if(userMap == null) {
			userMap = new HashMap<String,User>();
		}
		userMap.put(id, newUser);
		return newUser;
	}

	@Override
	public User getUser(String userId) {
		if(userMap != null && userMap.containsKey(userId)) {
			return userMap.get(userId);
		}else {
			return null;
		}
	}

	@Override
	public User deleteUser(String userId) {
		if(userMap != null && userMap.containsKey(userId)) {
			User us = userMap.remove(userId);
			return us;
		}else {
			return null;
		}
	}

	@Override
	public User putUser(String userId, User us) {
		if(userMap != null && userMap.containsKey(userId)) {
			User us2 = userMap.get(userId);
			us2.setEmail(us.getEmail());
			us2.setName(us.getName());
			return us2;
		}else {
			return null;
		}
	}

	@Override
	public Map<String, User> getAllUser() {
		return userMap;
	}

}
