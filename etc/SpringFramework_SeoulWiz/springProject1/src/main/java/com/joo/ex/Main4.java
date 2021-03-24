package com.joo.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main4 {
	public static void main(String[] args) {
		/*AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCTX4.xml");
		Admin4 admin = ctx.getBean("admin",Admin4.class);
		System.out.println(admin);
		ctx.close();*/
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config4.class);
		Admin4 admin = ctx.getBean("admin",Admin4.class);
		System.out.println(admin);
		ctx.close();
	}
}	
