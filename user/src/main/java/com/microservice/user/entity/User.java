package com.microservice.user.entity;

import java.sql.Timestamp;

import com.microservice.user.request.UserRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="app_user")
public class User {

	@Id
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="email")
	private String email;

	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;

	@Column(name="isActive")
	private boolean isActive;

	@Column(name="createdDate")
	private Timestamp createdDate;

	@Column(name="modifiedDate")
	private Timestamp modifiedDate;

	public User() {
	}
	
	public User(UserRequestDto userDto) {
		this.username = userDto.getUsername();
		this.password = userDto.getPassword();
		this.firstname = userDto.getFirstname();
		this.lastname = userDto.getLastname();
		this.email = userDto.getEmail();
		this.phone = userDto.getPhone();
		this.address = userDto.getAddress();
		this.isActive = userDto.isActive();
		this.createdDate = userDto.getCreatedDate();
		this.modifiedDate = userDto.getModifiedDate();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
