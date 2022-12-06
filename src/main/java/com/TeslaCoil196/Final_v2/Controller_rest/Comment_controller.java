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

import com.TeslaCoil196.Final_v2.Servie_service.CommentService;
import com.TeslaCoil196.Final_v2.payload.Comment_dto;

@RestController
@RequestMapping("/Comments")
@CrossOrigin("http://localhost:4200/")
public class Comment_controller {

	@Autowired
	CommentService cos;
	
	@PostMapping("/Candidate/{wgsid}/comments")
	public ResponseEntity<Comment_dto> create_comment(@RequestBody Comment_dto co, @PathVariable("wgsid") String wgsid){
		
		Comment_dto create_comment = cos.create_comment(co, wgsid);
		return new ResponseEntity<Comment_dto>(create_comment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{comment_id}")
	public ResponseEntity<?> deletecomment(@PathVariable("comment_id") Integer comment_id){
		
		cos.delete_comment(comment_id);
		return new ResponseEntity<>(Map.of("message","Comment was successfully deleated"),HttpStatus.OK);
	}
	
	@GetMapping("/all_comments")
	public ResponseEntity<List<Comment_dto>> all_comments(){
		List<Comment_dto> all = cos.getAll();
		return new ResponseEntity<>(all,HttpStatus.OK);
	}
}
