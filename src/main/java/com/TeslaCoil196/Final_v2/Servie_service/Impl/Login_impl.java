package com.TeslaCoil196.Final_v2.Servie_service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeslaCoil196.Final_v2.Entities.Login;
import com.TeslaCoil196.Final_v2.Repos.Login_repo;
import com.TeslaCoil196.Final_v2.Servie_service.Login_service;
import com.TeslaCoil196.Final_v2.payload.Login_dto;

@Service
public class Login_impl implements Login_service {

	@Autowired
	Login_repo lrp;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public Login_dto LoginByemailAndpassword(String email, String password) {
		Login lo = lrp.getUserByemailAndpassword(email, password);
		Login_dto ldp = this.LogintoDto(lo);
		return ldp;
	}

	@Override
	public Login_dto LoginByusernameAndpassword(String username, String password) {
		Login ll = lrp.getUserByemailAndpassword(username, password);
		Login_dto ld = this.LogintoDto(ll);
		return ld;
	}
	
	@Override
	public Login_dto FindByemail(String emailid) {
		Login lk = lrp.findByemail(emailid);
		Login_dto dt = this.LogintoDto(lk);
		return dt;
		
	}
	
	public Login_dto LogintoDto(Login L) {
		Login_dto ld = new Login_dto();
		
		ld.setEmail(L.getEmail());
		ld.setPassword(L.getPassword());
		ld.setUsernmae(L.getUsernmae());
		ld.setWgsid(L.getWgsid());
		
		return ld;
	}
	
	public Login DtoToLogin(Login_dto Ll) {
		Login l = new Login();
		
		l.setEmail(Ll.getEmail());
		l.setPassword(Ll.getPassword());
		l.setUsernmae(Ll.getUsernmae());
		l.setWgsid(Ll.getWgsid());
		 
		return l;
	}

	@Override
	public Login_dto save_login(Login_dto less) {
		Login map_1 = this.modelmapper.map(less, Login.class);
		Login saved_login = lrp.save(map_1);
		return this.modelmapper.map(saved_login, Login_dto.class);
	}

}
