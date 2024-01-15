package com.demo.api.service;

import java.util.List;

import com.demo.api.payload.UserDto;

public interface UserService {
	public UserDto createUser(UserDto us);
	public UserDto getUser(Integer userId);
	public UserDto deleteUser(Integer userId);
	public UserDto putUser(Integer userId, UserDto us);
	public List<UserDto> getAllUser();
}
