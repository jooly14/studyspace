package com.joo.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		/*String path = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		MyInfo info = ctx.getBean("myInfo", MyInfo.class);
		Student std1 = ctx.getBean("student1",Student.class);
		System.out.println(info);
		info.calc();
		System.out.println(std1);
		ctx.close();*/
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(annoConfig.class);
		MyInfo info = ctx.getBean("myInfo", MyInfo.class);
		Student std1 = ctx.getBean("student1",Student.class);
		System.out.println(info);
		info.calc();
		System.out.println(std1);
		ctx.close();
	}

}
