package com.smf.appbackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Preference {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Preference_Id")
	private String prefId;

	@NotNull(message = "Domains Mandatory")
	@Column(name = "Domains", length = 50, unique = true)
	private String domain;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId-FK", referencedColumnName = "User-Id")
	private User user;

}
