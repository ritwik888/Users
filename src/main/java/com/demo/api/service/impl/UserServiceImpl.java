package com.demo.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.exception.ResourceNotFoundException;
import com.demo.api.dao.UserDao;
import com.demo.api.entity.User;
import com.demo.api.payload.UserDto;
import com.demo.api.service.UserService;
import com.demo.api.utill.UserUtill;

@Service
public class UserServiceImpl implements UserService{
	
	Map<String,UserDto> userMap;
	UserUtill utill;
	
	@Autowired
	UserDao dao;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	public UserServiceImpl(UserUtill utill) {
		this.utill = utill;
	}

	@Override
	public UserDto getUser(Integer userId) {
		User user = dao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId.toString()));
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}
	
	@Override
	public UserDto createUser(UserDto us) {
		User newUser = mapper.map(us, User.class);
		newUser = dao.save(newUser);
		UserDto dto = mapper.map(newUser, UserDto.class);
		return dto;
	}	

	@Override
	public UserDto deleteUser(Integer userId) {
		User user = dao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId.toString()));
		dao.delete(user);
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public UserDto putUser(Integer userId, UserDto us) {
		User user = dao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId.toString()));
		User userentity = mapper.map(us, User.class);
		userentity.setId(userId);
		dao.save(userentity);
		UserDto savedDto = mapper.map(userentity, UserDto.class);
		return savedDto;
		}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = dao.findAll();
		List<UserDto> allUserDto = new ArrayList<>();
		for(User u : users) {
			allUserDto.add(mapper.map(u, UserDto.class));
		}
		return allUserDto;
	}

}
