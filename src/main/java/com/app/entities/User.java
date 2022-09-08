package com.app.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "user_name")
	private String name;
	
	private String email;
	
	private String password;
	
	private long phone;
	
	private String city;
	
	private int pin;
	
	private String address;
	
}
