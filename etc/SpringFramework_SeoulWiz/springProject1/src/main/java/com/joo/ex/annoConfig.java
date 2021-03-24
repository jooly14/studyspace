package com.joo.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCTX2.xml")/*애노테이션에 xml설정파일을 포함시키는 방법*/
public class annoConfig {
	
	@Bean
	public Student student1(){
		ArrayList<String> hobby = new ArrayList<>();
		hobby.add("hobby1");
		hobby.add("hobby2");
		hobby.add("hobby3");
		Student std = new Student("김초코");
		std.setHobby(hobby);
		std.setHeight(180);
		std.setNo(32);
		return std;
	}
}
