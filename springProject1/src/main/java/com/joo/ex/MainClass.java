package com.joo.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	/*
	 di : ���1 = a��ü �ȿ� b��ü c��ü�� ���� ~ ���� �����ϸ� �������� ����� ��
	 	  ** ���2 = a��ü�ȿ� setter�� �����ڸ� �̿��ؼ� �ܺο� ������ b��ü, c��ü�� a��ü�� �������ش�(���������� ���� ���)
	 	  �������̽��� �̿��ؼ� ��ǰ�� �������� �����.
	 ioc�����̳�(�����������̳�) : ��ǰ���� �����ؼ� ��� �ִ� ��
	 �������̶� ��ǰ�� �����ϰ� �����ϴ� ���̺귯�� ����ü
	  
	  
	  �������̽��� �̿��ϸ� �ڹ� �ڵ带 �������� �ʰ� xml���Ͽ��� Ŭ������ ������ �����ϸ� Ŭ������ ���氡���ϴ�
	  xml���ϸ� �����ϸ� ��
	  
	  
	  �� ������ �����̳� �����ֱ�
	  �����̳� ���� new GenericXmlApplicationContext();
	  �����̳� ���� ctx.load("classpath:applicationCTX.xml");ctx.refresh();
	  �����̳� ��� Calculation cal = ctx.getBean("calculator",Calculation.class);
	  �����̳� ���� ctx.close();
	  
	  
	�ؽ����� �� �����ֱ�
	InitializingBean ,DisposableBean �������̽��� �����ؼ� ���� ������ ��� ���ʱ�ȭ Ȥ�� �� �Ҹ� �������� �������̵��� �޼��尡 ȣ��ȴ�.
	�̿� �����ϰ� Ư�� �� �޼��尡 ���ʱ�ȭ,�Ҹ� �������� �ڵ����� ȣ��ǵ��� �ϰ� �ʹٸ� annotation�� Ȱ���� �� �ִ�. => @PostConstruct ,@PreDestroy�� Ư�� �޼������� �ۼ��ϸ� ��
 	�����̳� ����� ctx.close();
 	�� �Ҹ��� bean������.destroy();
	
	�ؽ����� ���� ���� (scope)
	default�� scope="singleton" bean�����Ҷ� scope�� ���� ������ �� �ִ�.
	�̱����̸� �ᱹ �ϳ��� ��ü�� �ٸ� ���������� ���� ���̱� ������ Ư�� ������ �����Ͽ� �ʵ��� ���� �����ϸ� �ٸ� ���������� �ʵ��� ���� ����ȴ�.
	
	�ؿܺ� ������ �̿��� ����
	1.Environment ��ü�� Ȱ��
		ctx(�����̳�)���� getEnvironment()�� Environment��ü�� �����ͼ� getPropertySources()�� PropertySources��ü�� ������
		PropertySources��ü�� PropertySources.addLast()�� �߰� Environment.getProperty()�� ����
	 
	2.properties������ ���������� Ȱ��
		xml�����̳� annotation�� ����ؼ� ������ �� ����
		
	3.profile �Ӽ��� �̿��� ����
		xml�����̳� annotation�� ����ؼ� ��������
	 */
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);	//������ �����̳� ����
		Calculation cal = ctx.getBean("calculator",Calculation.class);	//������Ʈ ������
		System.out.println(cal);
		System.out.println(cal.getMyCalc());
		ctx.close();
	}
}
