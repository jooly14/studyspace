package com.joo.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCTX2.xml")/*�ֳ����̼ǿ� xml���������� ���Խ�Ű�� ���*/
public class annoConfig {
	
	@Bean
	public Student student1(){
		ArrayList<String> hobby = new ArrayList<>();
		hobby.add("hobby1");
		hobby.add("hobby2");
		hobby.add("hobby3");
		Student std = new Student("������");
		std.setHobby(hobby);
		std.setHeight(180);
		std.setNo(32);
		return std;
	}
}
