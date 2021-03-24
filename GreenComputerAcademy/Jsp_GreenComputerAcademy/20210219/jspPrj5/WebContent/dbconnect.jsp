<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = null;
	ResultSet rs = null;
	
	String url = "jdbc:mysql://localhost:3307/jspdb";
	String dbId = "root";
	String dbPw = "1234";
%>