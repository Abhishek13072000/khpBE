package com.TeslaCoil196.Final_v2.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tags")
public class Tagss {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="Actual_Tag")
	String tag_content;
	
	@ManyToOne(targetEntity = Candidate.class)
	Candidate candidate_1;
	
	public Tagss() {
		// TODO Auto-generated constructor stub
	}
	
	public Tagss(int v1, String v2 ,Candidate v3) {
		id = v1;
		tag_content = v2;
		candidate_1 = v3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag_content() {
		return tag_content;
	}

	public void setTag_content(String tag_content) {
		this.tag_content = tag_content;
	}

	public Candidate getCandidate_1() {
		return candidate_1;
	}

	public void setCandidate_1(Candidate candidate_1) {
		this.candidate_1 = candidate_1;
	}

		
	
}
