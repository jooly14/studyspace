<%@page import="com.joo.dao.ADao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" trimDirectiveWhitespaces="true"%>
<%@ page import="org.json.simple.*" %>
<%
	ADao dao = new ADao();
	int result = dao.idChk(request.getParameter("id"));
	String rs1 = "";
	String rs2 = "���2";
	if(result>0){
		rs1 = "�̹� ������� ���̵�";
	}else{
		rs1 = "��밡���� ���̵�";
	}
	JSONObject json = new JSONObject();
	json.put("result", rs1);
	json.put("result2", rs2);
	out.print(json.toString());
%>
