package com.joo.ex;

public class Calculation {
	private int firstNum;
	private int secondNum;
	private MyCalc myCalc;
	public void add(){
		System.out.println("add");
	}
	public void sub(){
		System.out.println("sub");
	}
	public void mul(){
		System.out.println("mul");
	}
	public void div(){
		System.out.println("div");
	}
	public Calculation() {
		// TODO Auto-generated constructor stub
	}
	
	public Calculation(int firstNum, int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}

	
	public MyCalc getMyCalc() {
		return myCalc;
	}
	public void setMyCalc(MyCalc myCalc) {
		this.myCalc = myCalc;
	}
	public int getFirstNum() {
		return firstNum;
	}


	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}


	public int getSecondNum() {
		return secondNum;
	}


	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	@Override
	public String toString() {
		return "Calculation [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
	}
	
}
