<%@page import="com.joo.dto.DtoGB"%>
<%@page import="com.joo.dao.DaoGB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{
		box-sizing: border-box;
	}
	.wrap{
		width:500px;
		margin: 0 auto;
	}
	textarea{
		width: 100%;
		margin-top:6px;
		border : 1px solid #1eb49f;
	}
	input[type="submit"],input[type="button"]{
		width:50px;
		background-color: #1eb49f; 
		width: 100px;
		height:30px;
		border: none;
		color: white;
		margin: 5px;
		float: right;
	}
	input[type="password"]{
		margin-top:6px;
		height: 28px;
		border: 1px solid lightgray;
	}
	span{
		clear: both;
		width:100%;
		display: inline-block;
		font-size: 15px;
		color: red;
	}
</style>
<body>
<%	
	DaoGB dao = new DaoGB();
	String idx = request.getParameter("key");
	DtoGB dto = dao.getData(idx);
%>	
<c:set var="dto" value="<%=dto%>" />
<div class="wrap">

<form action="guestbookUpdateProc.jsp" method="post">
	<input type="hidden" name="idx" value="${dto.idx}"><br>
	작성자 : ${dto.id}<br>
	<textarea name="content" rows="5" >${dto.content}</textarea><br>
	<input type="hidden" name="id" value="${dto.id}">
	<input type="password" name="pw" placeholder="수정하려면 비밀번호 입력">
	<input type="submit" value="수정"><input type="button" onclick="location.href='guestbookList.jsp'" value="홈으로">
</form>
	<%
		if(request.getParameter("chk")!=null){
			%>
			<span>※ 비밀번호가 일치하지 않습니다.</span>
			<%
		}
%>
</div>
</body>
</html>