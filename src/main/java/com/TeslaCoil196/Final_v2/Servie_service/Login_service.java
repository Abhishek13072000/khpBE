package com.TeslaCoil196.Final_v2.Servie_service;

import com.TeslaCoil196.Final_v2.payload.Login_dto;

public interface Login_service {

	Login_dto LoginByemailAndpassword(String email, String password);
	
	Login_dto LoginByusernameAndpassword(String usename, String password);
	
	Login_dto FindByemail(String emailid);
	
	Login_dto save_login(Login_dto less);
	
}
