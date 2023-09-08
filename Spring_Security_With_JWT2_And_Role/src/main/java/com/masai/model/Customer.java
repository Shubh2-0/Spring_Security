package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	private String name;

	@Column(unique = true)
	private String email;

	/*
	 * AT THE TIME OF FETCHING ANY USER WE CAN'T SEE THIER PASSWORD BECUASE OF THIS
	 * PROPERTY
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String address;
	
	private String role;

}
