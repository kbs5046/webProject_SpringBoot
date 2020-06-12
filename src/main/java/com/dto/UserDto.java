package com.dto;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class UserDto {
	private int uID;
	private String username;
	private String password;
	private String name;
	private String email;
	private String salutation;
	private Timestamp datecreated;
	private String role;
	private MultipartFile photo;
    private byte[] bphoto;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public byte[] getBphoto() {
		return bphoto;
	}

	public void setBphoto(byte[] bphoto) {
		this.bphoto = bphoto;
	}

	@Override
	public String toString() {
		return "UserDto [uID=" + uID + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", salutation=" + salutation + ", datecreated=" + datecreated + ", role=" + role
				+ ", photo=" + photo + ", bphoto=" + Arrays.toString(bphoto) + "]";
	}

	

	
}
