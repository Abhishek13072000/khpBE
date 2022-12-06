package com.TeslaCoil196.Final_v2.Servie_service.Impl;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep.Tags;
import org.springframework.stereotype.Service;

import com.TeslaCoil196.Final_v2.Entities.Candidate;
import com.TeslaCoil196.Final_v2.Entities.Tagss;
import com.TeslaCoil196.Final_v2.Repos.Candidate_repo;
import com.TeslaCoil196.Final_v2.Servie_service.Candidate_service;
import com.TeslaCoil196.Final_v2.payload.Candidate_dto;
import com.TeslaCoil196.Final_v2.payload.Comment_dto;
import com.TeslaCoil196.Final_v2.payload.Tagss_dto;

@Service
public class Candiate_impl implements Candidate_service {

	@Autowired
	Candidate_repo crp;

	@Autowired
	ModelMapper modelmapper;
	
//	@Override
//	public List<Candidate_dto> byquater(Integer da) {
//		List<Candidate> quaterly = crp.quaterly(da);
//		List<Candidate_dto> Byq = quaterly.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
//				.collect(Collectors.toList());
//		return Byq;
//	}

	@Override
	public List<Candidate_dto> bymonths(Integer dave) {
		List<Candidate> monthly = crp.monthly(dave);
		List<Candidate_dto> Bytime = monthly.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return Bytime;
	}

	@Override
	public List<Candidate_dto> locateBylocation(String Location) {
		List<Candidate> findByloc = crp.FindBylocation(Location);
		List<Candidate_dto> loc = findByloc.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return loc;
	}
	
	@Override
	public List<Candidate_dto> locateBytechnology(String technology) {
		List<Candidate> findBytech = crp.FindBytechnology(technology);
		List<Candidate_dto> tech = findBytech.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return tech;
	}
	
	@Override
	public List<Candidate_dto> locateByWgs(String wgs) {
		List<Candidate> findBywgs = crp.FindBywgsid(wgs);
		List<Candidate_dto> WWW = findBywgs.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return WWW;
	}

	@Override
	public List<Candidate_dto> locateByAge(String Age) {
		List<Candidate> findByage = crp.FindByage(Age);
		List<Candidate_dto> CCC = findByage.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return CCC;
	}
	
	@Override
	public List<Candidate_dto> locateByName(String Name) {
		List<Candidate> findByname = crp.FindByname(Name);
		
		List<Candidate_dto> TTTT = findByname.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return TTTT;
	}
	
	@Override
	public List<Candidate_dto> locateBySkill(String skill) {
		List<Candidate> findByskill = crp.FindByskill(skill);
		
		List<Candidate_dto> CDDD = findByskill.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());
		return CDDD;
	}


	@Override
	public void chnage_status(String status_new, String candidate_id) {
		System.out.println("Status ran ");
		crp.changeStatus(status_new, candidate_id);

	}

	@Override
	public void change_data(Date date_new, String candidate_id) {
		System.out.println("Change _ date ran ");
		crp.changeDate____2(date_new, candidate_id);

	}

	@Override
	public Candidate_dto create_candidate(Candidate_dto candii) {

		Candidate cdd = this.DtoToCandidate(candii);
		Candidate saved_can = crp.save(cdd);
		return this.candidate_todto(saved_can);
	}

	@Override
	public Candidate_dto update_candidate(Candidate_dto cdt, String Candiadte_wgsid) throws Exception {
		Candidate cn = crp.findById(Candiadte_wgsid).get();
		if (cn == null) {
			throw new Exception("Candiate with WGSId :" + Candiadte_wgsid + " Was not in recordes");
		}

		cn.setWgsid(cdt.getWgsid());
		cn.setAge(cdt.getAge());
		cn.setLocation(cdt.getLocation());
		cn.setLwd(cdt.getLwd());
		cn.setMarital_status(cdt.getMarital_status());
		cn.setName(cdt.getName());
		cn.setRelevant_exp(cdt.getRelevant_exp());
		cn.setSkill(cdt.getSkill());
		cn.setStatus(cdt.getStatus());
		cn.setTechnology(cdt.getTechnology());
		cn.setTotal_exp(cdt.getTotal_exp());

		Candidate Candidate_updated = crp.save(cn);
		Candidate_dto ds = this.candidate_todto(Candidate_updated);

		return ds;
	}

	@Override
	public Candidate_dto status_status(Candidate_dto cande, String candidate_wgsid) throws Exception {

		Candidate candidate = crp.findById(candidate_wgsid).get();

		// System.out.println("Candidate found");

		if (candidate == null) {
			throw new Exception("Candiate with WGSId :" + candidate_wgsid + " Was not in recordes");
		}

		String status_new = cande.getStatus();

		candidate.setStatus(status_new);

		// System.out.println("status changed");

		Candidate saved_candy = crp.save(candidate);

		// System.out.println("candidate saved");

		Candidate_dto dto = this.modelmapper.map(saved_candy, Candidate_dto.class);

		return dto;

	}

	@Override
	public Candidate_dto getCandidateByWGSID(String can_wgsid) throws Exception {
		Candidate cc = crp.findById(can_wgsid).get();
		if (cc == null) {
			throw new Exception("Candiate with WGSId :" + can_wgsid + " Was not in recordes");
		}

		Candidate_dto dd = this.candidate_todto(cc);

		return dd;
	}

	@Override
	public List<Candidate_dto> getAllCandidates() {
		List<Candidate> Clist = crp.findAll();
		System.out.println(Clist);

		List<Candidate_dto> CDT = Clist.stream().map(Candidate -> this.modelmapper.map(Candidate, Candidate_dto.class))
				.collect(Collectors.toList());

		// List<Candidate_dto> CDT= Clist.stream().map(Candidate ->
		// this.candidate_todto(Candidate)).collect(Collectors.toList());
		return CDT;
	}

	@Override
	public void delete_candidate(String can_wgsid) {
		crp.deleteById(can_wgsid);
		System.out.println("Candiadte of WGSID : " + can_wgsid + " was Deleated");

	}

	public Candidate DtoToCandidate(Candidate_dto cdt) {

		Candidate cn = this.modelmapper.map(cdt, Candidate.class);

//		cn.setWgsid(cdt.getWgsid());
//		cn.setAge(cdt.getAge());
//		cn.setLocation(cdt.getLocation());
//		cn.setLwd(cdt.getLwd());
//		cn.setMarital_status(cdt.getMarital_status());
//		cn.setName(cdt.getName());
//		cn.setRelevant_exp(cdt.getRelevant_exp());
//		cn.setSkill(cdt.getSkill());
//		cn.setStatus(cdt.getStatus());
//		cn.setTechnology(cdt.getTechnology());
//		cn.setTotal_exp(cdt.getTotal_exp());

		return cn;

	}

	public Candidate_dto candidate_todto(Candidate c) {

		Candidate_dto cd = this.modelmapper.map(c, Candidate_dto.class);

//		cd.setWgsid(c.getWgsid());
//		cd.setAge(c.getAge());
//		cd.setLocation(c.getLocation());
//		cd.setLwd(c.getLwd());
//		cd.setMarital_status(c.getMarital_status());
//		cd.setName(c.getName());
//		cd.setRelevant_exp(c.getRelevant_exp());
//		cd.setSkill(c.getSkill());
//		cd.setStatus(c.getStatus());
//		cd.setTechnology(c.getTechnology());
//		cd.setTotal_exp(c.getTotal_exp());

		return cd;
	}

	



}
