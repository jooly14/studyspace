package com.joo.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware ,InitializingBean ,DisposableBean{
	private String id;
	private String pw;
	private Environment env;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	@Override
	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment()");
		setEnv(env);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		id = env.getProperty("admin.id");
		pw = env.getProperty("admin.pw");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}
	@Override
	public String toString() {
		return "AdminConnection [id=" + id + ", pw=" + pw + "]";
	}
	
}
