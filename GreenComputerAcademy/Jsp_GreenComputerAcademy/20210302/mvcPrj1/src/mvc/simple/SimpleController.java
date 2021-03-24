package mvc.simple;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String viewpage = "";
		Object resultObject = null;
		if(type==null || type.equals("greeting")){
			resultObject = "æ»≥Á«œººø‰";
			viewpage = "/simpleView.jsp";
		}else if(type.equals("date")){
			resultObject = new Date();
			viewpage = "/simpleView.jsp";
		}else{
			resultObject = "Invalid Type";
			viewpage = "/simpleView.jsp";
		}
		
		request.setAttribute("result", resultObject);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
	}

}
