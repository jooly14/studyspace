package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.ui.ExamConsole;

public class Program {
	public static void main(String[] args) {
		/*Exam exam = new NewLecExam();
		//ExamConsole console = new InlineExamConsole(exam);
		ExamConsole console = new GridExamConsole();	//부품 생성
		console.setExam(exam);							//부품 인젝션(결합)
*/			
		ApplicationContext context2 = new AnnotationConfigApplicationContext(NewlecDiConfig.class);
//		ExamConsole console = (ExamConsole) context.getBean("console");	// 방법1 : 이름을 이용해서 가져오는 밤법
		ExamConsole console = context2.getBean(ExamConsole.class);	// 방법2 : 타입만 가지고 가져오는 방법
//		Exam exam = context.getBean(Exam.class);	// 방법2 : 타입만 가지고 가져오는 방법
//		System.out.println(exam);
		console.print();
		
		
		//xml 설정파일에서 불러옴
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		List<Exam> exams = (List<Exam>) context.getBean("exams");
		for(Exam e : exams) {
			System.out.println(e);
		}
		
	}
}
