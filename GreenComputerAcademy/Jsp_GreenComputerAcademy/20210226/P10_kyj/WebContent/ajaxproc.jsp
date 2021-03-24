<%@page import="com.joo.dao.ADao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" trimDirectiveWhitespaces="true"%>
<%@ page import="org.json.simple.*" %>
<%
	ADao dao = new ADao();
	int result = dao.idChk(request.getParameter("id"));
	String rs1 = "";
	String rs2 = "결과2";
	if(result>0){
		rs1 = "이미 사용중인 아이디";
	}else{
		rs1 = "사용가능한 아이디";
	}
	JSONObject json = new JSONObject();
	json.put("result", rs1);
	json.put("result2", rs2);
	out.print(json.toString());
%>
