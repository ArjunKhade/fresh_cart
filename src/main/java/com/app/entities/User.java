package com.app.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity {
	
	private String name;
	
	@Column(length = 20, unique = true, nullable = false)
	private String email;
	
	private String password;
	
	private String phone;
	
	private String city;
	
	private String pin;
	
	private String address;
	
}
