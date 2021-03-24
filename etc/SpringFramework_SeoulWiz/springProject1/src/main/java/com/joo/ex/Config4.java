package com.joo.ex;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class Config4 {
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub.id}")
	private String subId;
	@Value("${sub.pw}")
	private String subPw;
	
	@Bean
	public static PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin4.properties");
		locations[1] = new ClassPathResource("sub_admin4.properties");
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	public Admin4 admin(){
		Admin4 admin = new Admin4();
		admin.setAdminId(adminId);
		admin.setAdminPw(adminPw);
		admin.setSubId(subId);
		admin.setSubPw(subPw);
		return admin;
	}
}
