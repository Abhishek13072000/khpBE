package com.TeslaCoil196.Final_v2.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Login")
@Getter
@Setter
public class Login {

	@Id
	@Column(name = "wgsid")
	String wgsid;

	@Column(name = "username")
	String usernmae;

	@Column(name = "email")
	String email;

	@Column(name = "password")
	String password;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getWgsid() {
		return wgsid;
	}

	public void setWgsid(String wgsid) {
		this.wgsid = wgsid;
	}

	public String getUsernmae() {
		return usernmae;
	}

	public void setUsernmae(String usernmae) {
		this.usernmae = usernmae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
