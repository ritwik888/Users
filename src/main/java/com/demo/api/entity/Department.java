package com.demo.api.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="department")
@Data
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="department_id")
	private Integer dep;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
    private Set<User> user;	

}
