package com.joo.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	/*
	 di : 방법1 = a객체 안에 b객체 c객체를 포함 ~ 직접 생성하면 의존성이 생기게 됨
	 	  ** 방법2 = a객체안에 setter나 생성자를 이용해서 외부에 생성된 b객체, c객체를 a객체에 주입해준다(스프링에서 쓰는 방법)
	 	  인터페이스를 이용해서 부품의 의존성을 낮춘다.
	 ioc컨테이너(스프링컨테이너) : 부품들을 생성해서 담고 있는 것
	 스프링이란 부품을 생성하고 조립하는 라이브러리 집합체
	  
	  
	 */
}
