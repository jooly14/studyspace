package com.yj;

class MyException extends Exception{
	public MyException(){
		super("����� ���� ����");
		
	}
}
public class ExceptionEx3 {
	public static void main(String[] args) {
		try {
			//method1();
			throw new Exception("���� �޽��� �����!!");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"\nȣ�� ���� ����:");
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
