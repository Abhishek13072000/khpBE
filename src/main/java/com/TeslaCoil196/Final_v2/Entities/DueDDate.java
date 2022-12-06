package com.TeslaCoil196.Final_v2.Entities;

import java.sql.Date;

public class DueDDate {
	
	Date due_date;
	String id;
	
	public DueDDate(Date v1, String v2) {
		due_date = v1;
		id = v2;
	}

	
	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
