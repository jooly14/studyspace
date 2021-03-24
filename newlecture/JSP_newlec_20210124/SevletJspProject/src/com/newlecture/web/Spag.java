package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CONTROLLER 역할(자바)
		int num = 0;
		if(request.getParameter("n")!=null&&!request.getParameter("n").equals("")){
			num = Integer.parseInt(request.getParameter("n"));
		}
		String result = "";	//MODEL 역할
		if(num%2!=0){
			result = "홀수";
		}else{
			result = "짝수";
		}
		String names[] = {"newlec","dragon"};
		Map<String, Object> notice = new HashMap<>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요");
		
		request.setAttribute("notice", notice);
		request.setAttribute("list", names);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}
}
