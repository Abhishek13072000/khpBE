package com.TeslaCoil196.Final_v2.Servie_service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeslaCoil196.Final_v2.Entities.Candidate;
import com.TeslaCoil196.Final_v2.Entities.Comment;
import com.TeslaCoil196.Final_v2.Repos.Candidate_repo;
import com.TeslaCoil196.Final_v2.Repos.Comment_repo;
import com.TeslaCoil196.Final_v2.Servie_service.CommentService;
import com.TeslaCoil196.Final_v2.payload.Comment_dto;


@Service
public class Comment_impl implements CommentService {
	
	@Autowired
	Candidate_repo cro;
	
	@Autowired
	Comment_repo cpo;
	
	@Autowired
	ModelMapper model_mapper;

	@Override
	public Comment_dto create_comment(Comment_dto comment_dto, String candidate_wgsid) {
		
		Candidate ccd = cro.findById(candidate_wgsid).get();
		
		Comment com = this.model_mapper.map(comment_dto, Comment.class);
		
		com.setCandidate(ccd);
		
		Comment saved_comment = cpo.save(com);
		
		
		return this.model_mapper.map(saved_comment, Comment_dto.class);
	}

	@Override
	public void delete_comment(Integer comment_id) {
		Comment comment = cpo.findById(comment_id).get();
		
		cpo.delete(comment); 

	}

	@Override
	public List<Comment_dto> getAll() {
		List<Comment> all_comments = cpo.findAll();
		
		List<Comment_dto> LCD = all_comments.stream().map(Comments -> this.model_mapper.map(Comments, Comment_dto.class)).collect(Collectors.toList()); 
		
		return LCD;
	}

}
