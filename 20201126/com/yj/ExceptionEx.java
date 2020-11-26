package com.yj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionEx {
	void readFile(String f) throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(f));
	}
	public static void main(String[] args) throws FileNotFoundException {
		ExceptionEx e = new ExceptionEx();
		e.readFile("aaa.txt");
	}
}
