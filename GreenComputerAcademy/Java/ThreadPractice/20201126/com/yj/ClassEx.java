package com.yj;

public class ClassEx {
	public ClassEx(){
		//ClassŬ���� ����ؼ� Ŭ���� �̸� �˾ƺ���
		System.out.println(this.getClass().getName());
	}
	public static void main(String[] args) {
		new ClassEx();
	}
}
