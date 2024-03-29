package com.demo.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="app_user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email_id")
	private String email;
	
	@Column(name="about")
	private String about;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	Department dep;

}
