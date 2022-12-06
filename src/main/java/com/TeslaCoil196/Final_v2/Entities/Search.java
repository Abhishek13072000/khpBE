package com.TeslaCoil196.Final_v2.Entities;

public class Search {

	String filterdata;
	String input;
	
	public Search() {
		// TODO Auto-generated constructor stub
	}
	
	public Search(String v1, String v2) {
		filterdata = v1;
		input = v2;
	}

	public String getFilterdata() {
		return filterdata;
	}

	public void setFilterdata(String filterdata) {
		this.filterdata = filterdata;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
}
