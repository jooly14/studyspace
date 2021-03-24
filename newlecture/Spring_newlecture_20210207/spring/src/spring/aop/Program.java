package spring.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;

public class Program {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/aop/setting.xml");
		//ApplicationContext context2 = new AnnotationConfigApplicationContext("spring.aop.setting.xml");
		/*Exam exam = new NewLecExam(1, 1, 1, 1);
		Exam proxy = (Exam) Proxy.newProxyInstance(NewLecExam.class.getClassLoader(), new Class[] {Exam.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				long start = System.currentTimeMillis();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object result = method.invoke(exam, args);
				
				long end = System.currentTimeMillis();
				String message = end-start +"밀리초 걸렸습니다.";
				System.out.println(message);
				return result;
			}
		});*/
		Exam exam = (Exam) context.getBean("exam");
		System.out.println("Total is "+exam.total());
		System.out.println();
		System.out.println("Total is "+exam.avg());
	}
}
