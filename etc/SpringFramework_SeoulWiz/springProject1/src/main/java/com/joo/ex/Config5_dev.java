package com.joo.ex;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Config5_dev {
	@Bean
	public ServerInfo info(){
		ServerInfo info = new ServerInfo();
		info.setIpNum("127.0.0.1");
		info.setPort("8181");
		return info;
	}
}