package com.TeslaCoil196.Final_v2.payload;

public class File_dto {
	
	String id;
	
	String name;
	
	String type;
	
	byte[] data;
	
	public File_dto(String name, String type, byte[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}
	
	public File_dto() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
	
}
