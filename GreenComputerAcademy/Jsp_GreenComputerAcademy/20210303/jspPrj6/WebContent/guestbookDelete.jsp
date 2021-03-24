<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		width:360px;
		margin: 0 auto;
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
		margin-top:7px;
		height: 28px;
		border: 1px solid lightgray;
	}
</style>
<body>
<div class="wrap">
<form action="guestbookDeleteProc.jsp" method="post">
	<%
		if(request.getParameter("chk")!=null){
			out.println("비밀번호가 일치하지 않습니다.<br>");
		}
	%>
	<input type="password" name="pw" placeholder="삭제하려면 비밀번호 입력">
	<input type="hidden" name="key" value="${param.key}">
	<input type="submit" value="삭제"><!-- <input type="button" onclick="location.href='guestbookList.jsp'" value="홈으로"> -->
</form>
</div>
</body>
</html>