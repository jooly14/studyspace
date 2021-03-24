package com.yj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionEx2 {
	void readFile(String f) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		ExceptionEx2 e = new ExceptionEx2();
		e.readFile("aaa.txt");
	}
}
