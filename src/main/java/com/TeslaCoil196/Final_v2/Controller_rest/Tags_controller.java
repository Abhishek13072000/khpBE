package com.TeslaCoil196.Final_v2.Controller_rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeslaCoil196.Final_v2.Servie_service.Tagss_service;
import com.TeslaCoil196.Final_v2.payload.Tagss_dto;

@RestController
@RequestMapping("/tags")
@CrossOrigin("http://localhost:4200/")
public class Tags_controller {
	
	@Autowired
	Tagss_service tit;
	
	@PostMapping("/Candidate/{wgsid}/tags")
    public ResponseEntity<Tagss_dto> create_tag(@RequestBody Tagss_dto td,@PathVariable("wgsid")String wgsid){
        
        Tagss_dto create_tag = tit.create_tag(td, wgsid);
//        System.out.println("Create_tag ran");
//        System.out.println(td);
//        System.out.println(wgsid);
        
        return new ResponseEntity<Tagss_dto>(create_tag,HttpStatus.CREATED);
    }
	
	@DeleteMapping("/tag/{id}")
	public ResponseEntity<?> delete_tag(@PathVariable("id") Integer id){
		tit.delete_tag(id);
		return new ResponseEntity<>(Map.of("message","Tag was successfully deleated"),HttpStatus.OK);
	}

	@GetMapping("/all_tags")
	public ResponseEntity<List<Tagss_dto>> all_tags(){
		List<Tagss_dto> getall_tags = tit.getall_tags();
		return new ResponseEntity<>(getall_tags,HttpStatus.OK);
	}
}
