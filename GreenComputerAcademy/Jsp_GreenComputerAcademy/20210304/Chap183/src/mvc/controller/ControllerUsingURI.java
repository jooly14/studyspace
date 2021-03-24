package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.*;

/**
 * Servlet implementation class ControllerUsingURI
 */
@WebServlet(urlPatterns={"/","/ControllerUsingURI"})

public class ControllerUsingURI extends HttpServlet {
	//<커맨드, 핸들러인스턴스> 매핑 정보 저장
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
		
	public void init() throws ServletException{
		
		/*String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		} catch(IOException e) {
			throw new ServletException(e);
		}*/
		
		String propFilePath = "mvc.prop.commandHandlerURI";
		ResourceBundle rb 
				= ResourceBundle.getBundle(propFilePath);
		Enumeration<String> actionEnum = rb.getKeys();
		while(actionEnum.hasMoreElements()){
			String command = actionEnum.nextElement();
			String className = rb.getString(command);
			System.out.println(command+" : "+className);
			
			try {
				Class handlerClass=Class.forName(className);//클래스 만듬
				
				CommandHandler handlerInstance 
				 = (CommandHandler) handlerClass.newInstance();//만든 클래스 생성
				
				commandHandlerMap.put(command, handlerInstance);
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		/*Iterator keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			//hello
			
			String handlerClassName = prop.getProperty(command);
			// mvc.HelloHandler
			
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				// 그 위치의 파일을 읽어와서 실제 클래스로 만들기
				
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();//생성
				// 읽어온 그 클래스를 생성(== new HelloHandler())랑 같음
				
				// 메모리에 올라가 있는 클래스로 만듬.
				
				commandHandlerMap.put(command, handlerInstance);
				// 쓰레드에 객체 넣는거랑 유사
				
				// map.put("아이디",outputstream);
				
				
				 // hello=mvc.HelloHandler
				 // ins=mvc.InsHandler
				 // del=mvc.DelHandle
				 
				
				
			} catch(ClassNotFoundException|InstantiationException|IllegalAccessException e) {
				throw new ServletException(e);
			}// 문자열을 이용해 실제 위치의 클래스를 찾아서 객체화 시킴
		}*/
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		command=command.substring(command.lastIndexOf("/"));
		
		System.out.println(command);
		
		/*if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(request.getContextPath().length());
		}*/
		
		//~~~~/ins.do ==> ins 가 command
		//~~~/del.do ==> del 이 command
		// 위의 두개가 key 입니다.
		CommandHandler handler = commandHandlerMap.get(command);
		//handler 변수에는 실제 생성된 HelloHandler / DelHandler...
		
		
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		
		// 여기서 부터
		try {
			viewPage = handler.process(request, response);
			           // 생성된 각 핸들러에는 process 메서드가 있음
			// viewPage에는 process의 리턴값이 담김
			// return 값은 이동할 페이지 임
			
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		// 여기 까지
		//=> if(cmd.equals("ins"){
		// 		dao.insert()
		//   }
		
		
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}


