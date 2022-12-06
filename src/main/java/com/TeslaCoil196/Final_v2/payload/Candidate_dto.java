package com.TeslaCoil196.Final_v2.payload;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Candidate_dto {

	String wgsid;

	String name;

	String age;

	String total_exp;

	String relevant_exp;

	String lwd;

	String location;

	String skill;

	String technology;

	String marital_status;

	String status;
	
	Set<Comment_dto> comments = new HashSet<>();
	
	Set<Tagss_dto> tages = new HashSet<>();

	Set<File_dto> filedb = new HashSet<>();
	
	Date due_date;
	
	java.util.Date Created;
	
	
	
	
	
	public Date getCreated() {
		return (Date) Created;
	}

	public void setCreated(Date created) {
		Created = created;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Set<File_dto> getFiledb() {
		return filedb;
	}

	public void setFiledb(Set<File_dto> filedb) {
		this.filedb = filedb;
	}

	


	public Set<Tagss_dto> getTages() {
		return tages;
	}

	public void setTages(Set<Tagss_dto> tages) {
		this.tages = tages;
	}

	public Set<Comment_dto> getComments() {
		return comments;
	}

	public void setComments(Set<Comment_dto> comments) {
		this.comments = comments;
	}

	public String getWgsid() {
		return wgsid;
	}

	public void setWgsid(String wgsid) {
		this.wgsid = wgsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTotal_exp() {
		return total_exp;
	}

	public void setTotal_exp(String total_exp) {
		this.total_exp = total_exp;
	}

	public String getRelevant_exp() {
		return relevant_exp;
	}

	public void setRelevant_exp(String relevant_exp) {
		this.relevant_exp = relevant_exp;
	}

	public String getLwd() {
		return lwd;
	}

	public void setLwd(String lwd) {
		this.lwd = lwd;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Candidate_dto() {
		// TODO Auto-generated constructor stub
	}

}
