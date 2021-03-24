package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc4")
public class CalcNum4 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		String exp = "";
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(int i =0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("exp")) {
					exp = cookies[i].getValue();
					break;
				}
			}
		}
		if(operator!= null&&operator.equals("C")) {
			exp ="";
		}else if(operator!= null&&operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			exp += (value==null)?"":value;
			exp += (operator==null)?"":operator;
			exp += (dot==null)?"":dot;
		}
		
		
		Cookie cookie = new Cookie("exp", exp);
		if(operator!= null&&operator.equals("C")) {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		response.sendRedirect("calcpage");
		
	}
}
