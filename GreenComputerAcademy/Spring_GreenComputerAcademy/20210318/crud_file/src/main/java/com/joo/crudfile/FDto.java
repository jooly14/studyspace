package com.joo.crudfile;

public class FDto {
	private int idx;
	private String filename;
	private String name;
	public FDto() {
		// TODO Auto-generated constructor stub
	}
	public FDto(int idx, String filename, String name) {
		this.idx = idx;
		this.filename = filename;
		this.name = name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
