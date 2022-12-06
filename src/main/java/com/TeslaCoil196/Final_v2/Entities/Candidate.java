package com.TeslaCoil196.Final_v2.Entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Candidate")
@Getter
@Setter
public class Candidate {
	
	@Id
	@Column(name="wgsid")
	String wgsid;
	
	@Column(name="name")
	String name;
	
	@Column(name="age")
	String age;
	
	@Column(name="total_exp")
	String total_exp;
	
	@Column(name="relevant_exp")
	String relevant_exp;
	
	@Column(name="expected_lwd")
	String lwd;
	
	@Column(name="location")
	String location;
	
	@Column(name="skills")
	String skill;
	
	@Column(name="technology")
	String technology;
	
	@Column(name="marital_status")
	String marital_status;
	
	@Column(name="status")
	String status;
	
	@Column(name="DueDate")
	Date due_date;

	@Column(name = "Created")
	@Temporal(TemporalType.DATE)
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


	@OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
	Set<Comment> comments = new HashSet<>();
	
	@OneToMany(mappedBy = "candidate_1", cascade = CascadeType.ALL)
	Set<Tagss> tages = new HashSet<>();
	
	@OneToMany(mappedBy = "candidate_2" , cascade = CascadeType.ALL)
	Set<FileDB> filedb = new HashSet<>();
	

	public Set<FileDB> getFiledb() {
		return filedb;
	}

	public void setFiledb(Set<FileDB> filedb) {
		this.filedb = filedb;
	}

	public Set<Tagss> getTages() {
		return tages;
	}

	public void setTages(Set<Tagss> tages) {
		this.tages = tages;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
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
	
	
	public Candidate() {
		// TODO Auto-generated constructor stub
	}

}
