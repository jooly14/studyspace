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
	//<Ŀ�ǵ�, �ڵ鷯�ν��Ͻ�> ���� ���� ����
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
				Class handlerClass=Class.forName(className);//Ŭ���� ����
				
				CommandHandler handlerInstance 
				 = (CommandHandler) handlerClass.newInstance();//���� Ŭ���� ����
				
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
				// �� ��ġ�� ������ �о�ͼ� ���� Ŭ������ �����
				
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();//����
				// �о�� �� Ŭ������ ����(== new HelloHandler())�� ����
				
				// �޸𸮿� �ö� �ִ� Ŭ������ ����.
				
				commandHandlerMap.put(command, handlerInstance);
				// �����忡 ��ü �ִ°Ŷ� ����
				
				// map.put("���̵�",outputstream);
				
				
				 // hello=mvc.HelloHandler
				 // ins=mvc.InsHandler
				 // del=mvc.DelHandle
				 
				
				
			} catch(ClassNotFoundException|InstantiationException|IllegalAccessException e) {
				throw new ServletException(e);
			}// ���ڿ��� �̿��� ���� ��ġ�� Ŭ������ ã�Ƽ� ��üȭ ��Ŵ
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
		
		//~~~~/ins.do ==> ins �� command
		//~~~/del.do ==> del �� command
		// ���� �ΰ��� key �Դϴ�.
		CommandHandler handler = commandHandlerMap.get(command);
		//handler �������� ���� ������ HelloHandler / DelHandler...
		
		
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		
		// ���⼭ ����
		try {
			viewPage = handler.process(request, response);
			           // ������ �� �ڵ鷯���� process �޼��尡 ����
			// viewPage���� process�� ���ϰ��� ���
			// return ���� �̵��� ������ ��
			
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		// ���� ����
		//=> if(cmd.equals("ins"){
		// 		dao.insert()
		//   }
		
		
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}


