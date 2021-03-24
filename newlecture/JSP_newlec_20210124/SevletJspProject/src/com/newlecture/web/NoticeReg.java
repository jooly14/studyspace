package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 	//돌려주는 값 파일형식 및 인코딩 방식 설정
		response.setCharacterEncoding("UTF-8");					//돌려주는 값 인코딩 방식 설정
		PrintWriter out = response.getWriter();
		String title_ = request.getParameter("title");
		String content_ = request.getParameter("content");
		
		out.println(title_+"<br>");
		out.println(content_);
	}
}
