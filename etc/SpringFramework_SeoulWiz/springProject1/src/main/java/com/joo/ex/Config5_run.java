package com.joo.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class Config5_run {
	@Bean
	public ServerInfo info(){
		ServerInfo info = new ServerInfo();
		info.setIpNum("222.222.222.222");
		info.setPort("9090");
		return info;
	}
}
