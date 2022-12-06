package com.TeslaCoil196.Final_v2.Servie_service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeslaCoil196.Final_v2.Entities.Candidate;
import com.TeslaCoil196.Final_v2.Entities.Tagss;
import com.TeslaCoil196.Final_v2.Repos.Candidate_repo;
import com.TeslaCoil196.Final_v2.Repos.Tagss_repo;
import com.TeslaCoil196.Final_v2.Servie_service.Tagss_service;
import com.TeslaCoil196.Final_v2.payload.Tagss_dto;

@Service
public class Tagss_impl implements Tagss_service {

	@Autowired
	Candidate_repo crro;
	
	@Autowired
	ModelMapper model_mapper;
	
	@Autowired
	Tagss_repo taz;
	
	@Override
	public Tagss_dto create_tag(Tagss_dto tagss_dto, String Candidate_wgsid) {
		
		Candidate cdt = crro.findById(Candidate_wgsid).get();
		
		Tagss tt = this.model_mapper.map(tagss_dto, Tagss.class);
		
		tt.setCandidate_1(cdt);
		
		Tagss saved_tag = taz.save(tt);
		
		
		return this.model_mapper.map(saved_tag, Tagss_dto.class);
	}

	@Override
	public void delete_tag(Integer tag_id) {
		Tagss del_tagss = taz.findById(tag_id).get();
		
		taz.delete(del_tagss);

	}

	@Override
	public List<Tagss_dto> getall_tags() {
		List<Tagss> findAll_tags = taz.findAll();
		
		List<Tagss_dto> collect_tags = findAll_tags.stream().map(tag-> this.model_mapper.map(tag, Tagss_dto.class)).collect(Collectors.toList());
		
		return collect_tags;
	}

}
