package com.joo.ex;

import java.util.ArrayList;

public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMICalculator calculator;
	public MyInfo() {
		// TODO Auto-generated constructor stub
	}
	public MyInfo(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MyInfo [name=" + name + ", height=" + height + ", weight=" + weight + ", hobby=" + hobby + "]";
	}
	public void calc(){
		calculator.calc(weight, height);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public ArrayList<String> getHobby() {
		return hobby;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	public BMICalculator getCalculator() {
		return calculator;
	}
	public void setCalculator(BMICalculator calculator) {
		this.calculator = calculator;
	}
	
}
