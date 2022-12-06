package com.TeslaCoil196.Final_v2.Servie_service;


import java.util.List;

import com.TeslaCoil196.Final_v2.payload.Comment_dto;

public interface CommentService {

	Comment_dto create_comment(Comment_dto comment_dto, String candidate_wgsid);
	
	void delete_comment(Integer comment_id);
	
	List<Comment_dto> getAll();
}
