package com.TeslaCoil196.Final_v2.Servie_service;

import java.util.List;

import com.TeslaCoil196.Final_v2.payload.Tagss_dto;

public interface Tagss_service {

	Tagss_dto create_tag(Tagss_dto tagss_dto, String Candidate_wgsid);
	
	void delete_tag(Integer tag_id);
	
	List<Tagss_dto> getall_tags();
}
