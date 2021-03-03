package com.joo.ex;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main5 {
	public static void main(String[] args) {
		System.out.println("dev/run?");
		Scanner scan = new Scanner(System.in);
		String profile = scan.nextLine();
		scan.close();
		
		/*GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile);
		ctx.load("classpath:appCTX5_dev.xml","classpath:appCTX5_run.xml");
		ctx.refresh();
		ServerInfo info = ctx.getBean("info",ServerInfo.class);
		System.out.println(info);
		ctx.close();*/
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile);
		ctx.register(Config5_dev.class,Config5_run.class);
		ctx.refresh();
		ServerInfo info = ctx.getBean("info",ServerInfo.class);
		System.out.println(info);
		ctx.close();
	}
}
