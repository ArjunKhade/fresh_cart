package com.app.entities;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



	
	@Entity
	@Table(name = "email_activation_codes")
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	public class EmailActivationCodes extends BaseEntity {
	  
	  @Column(length = 50, nullable = false)
	  private String email;
	  
	  @Column(nullable = false)
	  private String code;
	  
	  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	  @Column(nullable = false)
	  private LocalDateTime validity;
	}

