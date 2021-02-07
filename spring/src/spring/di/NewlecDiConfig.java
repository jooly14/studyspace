package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewLecExam;

@ComponentScan("spring.di.ui")
@Configuration
public class NewlecDiConfig {
	
	@Bean
	public Exam exam(){
		return new NewLecExam(10,20,30,40);
	}
}
