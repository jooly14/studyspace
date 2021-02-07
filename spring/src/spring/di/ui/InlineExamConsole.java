package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component
public class InlineExamConsole implements ExamConsole {
	@Autowired(required = false)
//	@Qualifier("exam")
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("default constructor");
	}
	public InlineExamConsole(Exam exam) {
		System.out.println("overload constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam==null)
			System.out.printf("total is %d , avg is %f\n",0, 0.0);
		else
			System.out.printf("total is %d , avg is %f\n",exam.total(), exam.avg());
	}
	
	
	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam = exam;
	}

}
