package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Nuna extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
//		System.out.println(response.getContentType());
//		System.out.println(response.getCharacterEncoding());
		PrintWriter out = response.getWriter();
		int cnt = 100;
		String cnt_ = request.getParameter("cnt");
		if(cnt_!=null&&!cnt_.equals("")) {
			cnt = Integer.parseInt(cnt_);
		}
		
		for(int i=0;i<cnt;i++){
			out.println((i+1)+": 안녕 Servlet!!<br>");
		}
	}
}
