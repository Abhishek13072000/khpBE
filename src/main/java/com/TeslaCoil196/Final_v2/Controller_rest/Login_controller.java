package com.TeslaCoil196.Final_v2.Controller_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeslaCoil196.Final_v2.Servie_service.Login_service;
import com.TeslaCoil196.Final_v2.payload.Login_dto;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200/")
public class Login_controller {

	@Autowired
	Login_service lse;
	
	
	@PostMapping("/new_login")
	public ResponseEntity<Login_dto> new_login(@RequestBody Login_dto ldt){
		
		Login_dto save_login = lse.save_login(ldt);
		
		
		return new ResponseEntity<Login_dto>(save_login,HttpStatus.CREATED);
	}
	
	@GetMapping("/username")
	public ResponseEntity<Login_dto> loginByUsername(@RequestBody Login_dto ldt1){
		
		String username = ldt1.getUsernmae();
		String password = ldt1.getPassword();
		
		Login_dto byusernameAndpassword = lse.LoginByusernameAndpassword(username, password);
		return new ResponseEntity<Login_dto>(byusernameAndpassword,HttpStatus.FOUND);
	}
	
	@PostMapping("/email")
	public ResponseEntity<Login_dto> loginByemail(@RequestBody Login_dto ldt2){
		
		String email = ldt2.getEmail();
		String password = ldt2.getPassword();
		
		System.out.println("email :"+email);
		System.out.println("password :"+password);
		
		Login_dto byusernameAndpassword = lse.LoginByemailAndpassword(email, password);
		return new ResponseEntity<Login_dto>(byusernameAndpassword,HttpStatus.FOUND);
	}
	
	@PostMapping("/email_2")
	public Login_dto loginByemail_2(@RequestBody Login_dto ldt2){
		
		String email = ldt2.getEmail();
		String password = ldt2.getPassword();
		
		System.out.println("email :"+email);
		System.out.println("password :"+password);
		
		Login_dto byusernameAndpassword = lse.LoginByemailAndpassword(email, password);
		return byusernameAndpassword;
	}
	
	@GetMapping("/temp")
	public void er() {
		System.out.println("NOT A PROBLEM OF CORS POLICY");
	}
}
