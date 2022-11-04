package com.smf.appbackend.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SMF-Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User-Id")
	private String userId;

	@NotNull(message = "User First Name is needed")
	@Column(name = "User-FirstName", length = 20)
	private String userFname;

	@NotNull(message = "User First Name is needed")
	@Column(name = "User-LastName", length = 20)
	private String userLname;

	@Column(name = "User-Email")
	@Email(message = "Email is not valid")
	@NotNull(message = "Email cannot be null")
	private String email;

	@Column(name = "phone_number")
	@NotNull(message = "Phone number cannot be null")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number is not valid")
	private String phoneNumber;

	@NotNull(message = "Gender needed")
	@Column(name = "Gender", length = 15)
	private String gender;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Preference> preferences;

}
