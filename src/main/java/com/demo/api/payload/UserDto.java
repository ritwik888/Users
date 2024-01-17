package com.demo.api.payload;

public class UserDto {
	private String name;
	private String id;
	private String email;
	private Integer dep;
	private String about;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getDep() {
		return dep;
	}
	public void setDep(Integer dep) {
		this.dep = dep;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
}
