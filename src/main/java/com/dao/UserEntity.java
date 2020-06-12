package com.dao;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boot_users_tbl")
public class UserEntity {
	private int uID;
	private String username;
	private String password;
	private String name;
	private String email;
	private String salutation;
	private Timestamp datecreated;
	private String role;
	private byte[] bphoto;
	
	
	@Column(columnDefinition = "longblob")
	public byte[] getBphoto() {
		return bphoto;
	}

	public void setBphoto(byte[] bphoto) {
		this.bphoto = bphoto;
	}

	@Column(columnDefinition = "VARCHAR(30)  DEFAULT 'customer'")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	@Column(columnDefinition = "VARCHAR(100)  NOT NULL")
	public String getPassword() {
		return password;
	}

	@Column(columnDefinition = "VARCHAR(100)  NOT NULL")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(columnDefinition = "VARCHAR(100)  NOT NULL")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(columnDefinition = "VARCHAR(100)  NOT NULL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(columnDefinition = "VARCHAR(5)  NOT NULL")

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	@Column(columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	@Override
	public String toString() {
		return "UserEntity [uID=" + uID + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", salutation=" + salutation + ", datecreated=" + datecreated + ", role=" + role
				+ ", bphoto=" + Arrays.toString(bphoto) + "]";
	}

	
	
	
	
}
