package com.demo.api.exception;

import java.util.Date;

public class UserException extends Throwable{
	private String message;
	private Date time;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}
