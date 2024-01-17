package com.demo.api.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

	public ApiResponse() {
		super();
	}

	public ApiResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	private String status;
	private String message;
}
