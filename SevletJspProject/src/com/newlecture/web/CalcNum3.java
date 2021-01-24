package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/calc3")
public class CalcNum3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();	//어플리케이션(서블릿컨텍스트) 이용한 데이터 저장
		HttpSession session = request.getSession();					//세션을 이용한 데이터 저장
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int v_ = Integer.parseInt(request.getParameter("v"));
		String oper_ = request.getParameter("operator");
		PrintWriter out = response.getWriter();
		//계산
		if(oper_.equals("=")) {
//			int num1 = (int)application.getAttribute("value");
//			oper_ = (String)application.getAttribute("operator");
			
//			int num1 = (int)session.getAttribute("value");
//			oper_ = (String)session.getAttribute("operator");
			int num1 =0;
			Cookie[] cookies = request.getCookies();
			for(int i =0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("value")) {
					num1 = Integer.parseInt(cookies[i].getValue());
				}else if(cookies[i].getName().equals("operator")){
					oper_ = cookies[i].getValue();
				}
			}
				
			int num2 = v_;
			if(oper_.equals("+")) {
				out.println("<h1> 결과는"+(num1+num2)+"</h1>");
			}else {
				out.println("<h1> 결과는"+(num1-num2)+"</h1>");
			}
			
		//저장
		}else {
//			application.setAttribute("value", v_);
//			application.setAttribute("operator", oper_);
			
//			session.setAttribute("value", v_);
//			session.setAttribute("operator", oper_);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v_) );
			Cookie operCookie = new Cookie("operator", String.valueOf(oper_) );
			valueCookie.setPath("/calc3");
			operCookie.setPath("/calc3");
//			valueCookie.setMaxAge(60*5);
//			operCookie.setMaxAge(60*5);
			response.addCookie(valueCookie);
			response.addCookie(operCookie);
			response.sendRedirect("/calc3.html");
		}
		
	}
}
