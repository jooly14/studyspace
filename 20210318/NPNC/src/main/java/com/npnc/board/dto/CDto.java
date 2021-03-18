package com.npnc.board.dto;

public class CDto {
	private int idx;	//ī�װ� �ε���
	private String maincategory;
	private String name;	//ī�װ� �̸�
	private int readgrade;	//�б� ����
	private int writegrade;	//���� ����
	
	public CDto() {
		// TODO Auto-generated constructor stub
	}

	public CDto(int idx, String maincategory, String name, int readgrade, int writegrade) {
		this.idx = idx;
		this.maincategory = maincategory;
		this.name = name;
		this.readgrade = readgrade;
		this.writegrade = writegrade;
	}
	

	public String getMaincategory() {
		return maincategory;
	}

	public void setMaincategory(String maincategory) {
		this.maincategory = maincategory;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReadgrade() {
		return readgrade;
	}

	public void setReadgrade(int readgrade) {
		this.readgrade = readgrade;
	}

	public int getWritegrade() {
		return writegrade;
	}

	public void setWritegrade(int writegrade) {
		this.writegrade = writegrade;
	}
}
