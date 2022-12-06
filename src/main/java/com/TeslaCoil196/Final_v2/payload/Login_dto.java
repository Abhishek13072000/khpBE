package com.TeslaCoil196.Final_v2.payload;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Login_dto {
	
	String wgsid;

	String usernmae;
	
	String email;
	
	String password;
	
	public Login_dto() {
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
