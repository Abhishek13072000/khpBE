package com.TeslaCoil196.Final_v2.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="Actual_comment")
	String content;
	
	@ManyToOne(targetEntity = Candidate.class)	
	Candidate candidate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int v1, String v2 ,Candidate v3) {
		id = v1;
		content = v2;
		candidate = v3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	

}
