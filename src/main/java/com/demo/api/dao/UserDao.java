package com.demo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
