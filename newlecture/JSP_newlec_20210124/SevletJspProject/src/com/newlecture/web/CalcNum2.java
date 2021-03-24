package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class CalcNum2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String[] nums_ = request.getParameterValues("num");
		String oper_ = request.getParameter("operator");
		
		int result = 0;
		for(int i=0;i<nums_.length;i++) {
			int num = Integer.parseInt(nums_[i]);
			result += num;
		}
		
		PrintWriter out = response.getWriter();
		if(oper_.equals("덧셈")) {
			out.println("<h1> 결과는"+(result)+"</h1>");
		}
	}
}
