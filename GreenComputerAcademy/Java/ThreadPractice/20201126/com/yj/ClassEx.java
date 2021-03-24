package com.yj;

public class ClassEx {
	public ClassEx(){
		//Class클래스 사용해서 클래스 이름 알아보기
		System.out.println(this.getClass().getName());
	}
	public static void main(String[] args) {
		new ClassEx();
	}
}
