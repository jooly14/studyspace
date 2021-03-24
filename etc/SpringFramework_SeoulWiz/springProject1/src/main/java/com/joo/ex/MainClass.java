package com.joo.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	/*
	 di : 방법1 = a객체 안에 b객체 c객체를 포함 ~ 직접 생성하면 의존성이 생기게 됨
	 	  ** 방법2 = a객체안에 setter나 생성자를 이용해서 외부에 생성된 b객체, c객체를 a객체에 주입해준다(스프링에서 쓰는 방법)
	 	  인터페이스를 이용해서 부품의 의존성을 낮춘다.
	 ioc컨테이너(스프링컨테이너) : 부품들을 생성해서 담고 있는 것
	 스프링이란 부품을 생성하고 조립하는 라이브러리 집합체
	  
	  
	  인터페이스를 이용하면 자바 코드를 수정하지 않고 xml파일에서 클래스만 설정을 수정하면 클래스를 변경가능하다
	  xml파일만 수정하면 됨
	  
	  
	  ※ 스프링 컨테이너 생명주기
	  컨테이너 생성 new GenericXmlApplicationContext();
	  컨테이너 설정 ctx.load("classpath:applicationCTX.xml");ctx.refresh();
	  컨테이너 사용 Calculation cal = ctx.getBean("calculator",Calculation.class);
	  컨테이너 종료 ctx.close();
	  
	  
	※스프링 빈 생명주기
	InitializingBean ,DisposableBean 인터페이스를 구현해서 빈을 생성한 경우 빈초기화 혹은 빈 소멸 과정에서 오버라이드한 메서드가 호출된다.
	이와 유사하게 특정 빈 메서드가 빈초기화,소멸 과정에서 자동으로 호출되도록 하고 싶다면 annotation을 활용할 수 있다. => @PostConstruct ,@PreDestroy를 특정 메서드위에 작성하면 됨
 	컨테이너 종료는 ctx.close();
 	빈 소멸은 bean변수명.destroy();
	
	※스프링 빈의 범위 (scope)
	default는 scope="singleton" bean생성할때 scope를 따로 설정할 수 있다.
	싱글톤이면 결국 하나의 객체를 다른 참조변수에 담을 뿐이기 때문에 특정 변수를 참조하여 필드의 값을 변경하면 다른 변수에서도 필드의 값이 변경된다.
	
	※외부 파일을 이용한 설정
	1.Environment 객체를 활용
		ctx(컨테이너)에서 getEnvironment()로 Environment객체를 가져와서 getPropertySources()로 PropertySources객체를 가져옴
		PropertySources객체에 PropertySources.addLast()로 추가 Environment.getProperty()로 추출
	 
	2.properties파일을 직접적으로 활용
		xml파일이나 annotation을 사용해서 가져올 수 있음
		
	3.profile 속성을 이용한 설정
		xml파일이나 annotation을 사용해서 설정가능
	 */
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);	//스프링 컨테이너 생성
		Calculation cal = ctx.getBean("calculator",Calculation.class);	//컴포넌트 가져옴
		System.out.println(cal);
		System.out.println(cal.getMyCalc());
		ctx.close();
	}
}
