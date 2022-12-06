package com.TeslaCoil196.Final_v2.Controller_rest;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TeslaCoil196.Final_v2.Entities.Candidate;
import com.TeslaCoil196.Final_v2.Entities.DueDDate;
import com.TeslaCoil196.Final_v2.Entities.Search;
import com.TeslaCoil196.Final_v2.Entities.Status;
import com.TeslaCoil196.Final_v2.Repos.Candidate_repo;
import com.TeslaCoil196.Final_v2.Servie_service.Candidate_service;
import com.TeslaCoil196.Final_v2.Servie_service.Login_service;
import com.TeslaCoil196.Final_v2.payload.Candidate_dto;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class Controller_controller {

	@Autowired
	Candidate_service cs;

	@Autowired
	Login_service css;
	/////////////////
	@Autowired
	Candidate_repo cde;

	@PostMapping("/searchData")
	public List<Candidate_dto> mixed(@RequestBody Search fromFiler) {
		Date created;
		Date ddue;
		String filter = fromFiler.getFilterdata().toLowerCase();
		// System.out.println("FIlter :"+filter);
		String search_data = fromFiler.getInput();
		// System.out.println("Input :"+search_data);
		List<Candidate_dto> common = null;
		switch (filter) {
		case "age": {
			return common = cs.locateByAge(search_data);
		}
		case "name": {
			return common = cs.locateByName(search_data);
		}
		case "skill": {
			return common = cs.locateBySkill(search_data);
		}
		case "due_date": {
			return common = cs.bymonths(Integer.parseInt(search_data));
		}
		case "location": {
			return common = cs.locateBylocation(search_data);
		}
		case "technology": {
			return common = cs.locateBytechnology(search_data);
		}
		case "wgsid": {
			return common = cs.locateByWgs(search_data);
		}
		case "quater_1": {
			common = cs.bymonths(1);
			common.addAll(cs.bymonths(2));
			common.addAll(cs.bymonths(3));
			return common;
		}
		case "quater_2": {
			common = cs.bymonths(4);
			common.addAll(cs.bymonths(5));
			common.addAll(cs.bymonths(6));
			return common;
		}
		case "quater_3": {
			common = cs.bymonths(7);
			common.addAll(cs.bymonths(8));
			common.addAll(cs.bymonths(9));
			return common;
		}
		case "quater_4": {
			common = cs.bymonths(10);
			common.addAll(cs.bymonths(11));
			common.addAll(cs.bymonths(12));
			return common;
		}
		case "all":{
		    return common= cs.getAllCandidates();
		}
		
		}
		return common;

	}

	@PostMapping("/average")
	public List<Search> aavvrage(@RequestBody Search FFF) {
		System.out.println("------------>");
		System.out.println(FFF.getFilterdata().toLowerCase());
		System.out.println(FFF.getInput());
		Date created;
		Date ddue;
		long difference_In_Days = 0;
		int ans = 0;
		int size = cs.getAllCandidates().size();
		List<Search> sar = new ArrayList<Search>();

		String filterdata = FFF.getFilterdata().toLowerCase();
		String search_data = FFF.getInput();

		//Search ff = new Search();

		switch (filterdata) {
			case "location": {
			System.out.println("-->" + search_data);
			List<Candidate_dto> loc = cs.locateBylocation(search_data);

			for (Candidate_dto i : loc) {
				created = i.getCreated();
				ddue = i.getDue_date();
				long ttime = ddue.getTime() - created.getTime();
				difference_In_Days = difference_In_Days + (ttime / (1000 * 60 * 60 * 24)) % 365;
			}
			ans = (int) (difference_In_Days / size);
			Search ff_1 = new Search(FFF.getInput(), Integer.toString(ans));
			sar.add(ff_1);
			break;
		}
			case "every": {
				
			List<Candidate_dto> ogloc = cs.getAllCandidates();
			for (Candidate_dto i : ogloc) {
				created = i.getCreated();
				ddue = i.getDue_date();
				long ttime = ddue.getTime() - created.getTime();
				difference_In_Days = difference_In_Days + (ttime / (1000 * 60 * 60 * 24)) % 365;
			}
			ans = (int) (difference_In_Days / size);
			Search ff_2 = new Search("Average of all locations", Integer.toString(ans));
			sar.add(ff_2);
			break;

		}
	}
		return sar;
	}

	@PutMapping("/updateStatus")
	public String upStatus(@RequestBody Status statusObj) {
		cs.chnage_status(statusObj.getStat(), statusObj.getId());
		return "message";

	}

	@PutMapping("/updateDate")
	public String upDate(@RequestBody DueDDate ddd) {
		System.out.println("Due date : " + ddd.getDue_date());
		cs.change_data(ddd.getDue_date(), ddd.getId());
		return "message";

	}

	@PostMapping("/new_candidate")
	public ResponseEntity<Candidate_dto> creater_candidate(@RequestBody Candidate_dto cto) {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("utilDate:" + utilDate);
		System.out.println("sqlDate:" + sqlDate);

		cto.setCreated(sqlDate);

		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_YEAR, 30);
		java.util.Date time1 = c1.getTime();
		java.sql.Date add_sqldate = new java.sql.Date(time1.getTime());

		cto.setDue_date(add_sqldate);

		Candidate_dto new_candidate = cs.create_candidate(cto);
		return new ResponseEntity<>(new_candidate, HttpStatus.CREATED);
	}

	@GetMapping("/ALL")
	public ResponseEntity<List<Candidate_dto>> All_candies() {
		List<Candidate_dto> LL = cs.getAllCandidates();

		return new ResponseEntity<>(LL, HttpStatus.FOUND);
	}

	@DeleteMapping("/delete/{wgsid}")
	public ResponseEntity<?> deleter(@PathVariable("wgsid") String wgsid) {
		cs.delete_candidate(wgsid);
		return new ResponseEntity<>(Map.of("message", "User was successfully deleted"), HttpStatus.OK);
	}

	@PutMapping("/update/{wgsid}")
	public ResponseEntity<Candidate_dto> update(@RequestBody Candidate_dto cdt, @PathVariable("wgsid") String wgsid)
			throws Exception {
		Candidate_dto de = cs.update_candidate(cdt, wgsid);
		return new ResponseEntity<>(de, HttpStatus.ACCEPTED);
	}

	@GetMapping("/get_one/{wgsid}")
	public ResponseEntity<Candidate_dto> find_one(@PathVariable("wgsid") String wgsid) throws Exception {
		Candidate_dto ess = cs.getCandidateByWGSID(wgsid);
		return new ResponseEntity<>(ess, HttpStatus.OK);
	}

	@PutMapping("/updateStatus/{wgsid}/{new_status}")
	public ResponseEntity<?> update_status(@PathVariable("wgsid") String wgsid,
			@PathVariable("new_status") String new_status) {

		cs.chnage_status(new_status, wgsid);
		return new ResponseEntity<>(Map.of("message", "Candidate status was successfully updated"), HttpStatus.OK);

	}

	@PutMapping("/updateStatus_1/{wgsid}")
	public ResponseEntity<?> update_status__1(@RequestBody Candidate_dto car, @PathVariable("wgsid") String wgsid)
			throws Exception {

//		System.out.println("wgsid: "+wgsid);
//		System.out.println("new status: "+ car.getStatus());

		cs.status_status(car, wgsid);
		return new ResponseEntity<>(Map.of("message", "Candidate status was successfully updated"), HttpStatus.OK);

	}

	@GetMapping("/all_2")
	public List<Candidate_dto> all_candies() {
		List<Candidate_dto> LL = cs.getAllCandidates();
		return LL;
	}
}
