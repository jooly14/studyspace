package com.joo.ex;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main3 {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources ps = env.getPropertySources();
		try {
			ps.addLast(new ResourcePropertySource("classpath:admin.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(env.getProperty("admin.id"));
		System.out.println(env.getProperty("admin.pw"));
		
		GenericXmlApplicationContext ctx2 = (GenericXmlApplicationContext)ctx;
		ctx2.load("classpath:appCTX.xml");
		ctx2.refresh();
		AdminConnection conn = ctx2.getBean("conn",AdminConnection.class);
		System.out.println(conn);
		ctx2.close();
		ctx.close();
	}

}
