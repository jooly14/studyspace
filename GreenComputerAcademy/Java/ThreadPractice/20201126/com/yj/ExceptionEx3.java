package com.yj;

class MyException extends Exception{
	public MyException(){
		super("사용자 정의 예외");
		
	}
}
public class ExceptionEx3 {
	public static void main(String[] args) {
		try {
			//method1();
			throw new Exception("예외 메시지 만들기!!");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"\n호출 스택 내용:");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void method1() throws MyException{
		throw new MyException();
	}
}
