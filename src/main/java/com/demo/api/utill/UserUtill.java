package com.demo.api.utill;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserUtill {
	
	public String generateRandomId() {
		return UUID.randomUUID().toString();
	}

}
