<%@page import="com.joo.dto.DtoGB"%>
<%@page import="java.util.Vector"%>
<%@page import="com.joo.dao.DaoGB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		width:50%;
		margin: 0 auto;
	}
	textarea{
		width:100%;
		border : 1px solid #1eb49f;
		padding:10px ;
	}
	textarea::placeholder{
		color:#1eb49f;
	}
	
	input[type="submit"]{
		width:50px;
		background-color: #1eb49f; 
		width: 100px;
		height:30px;
		border: none;
		color: white;
		/* position: absolute;
		botton:0px;
		right:0px; */
		float:right;
	}
	.f1 button{
		background-color: transparent;
		border: none;
		color: gray;
	}
	.f2{
		width:100%;
		display: flex;
		flex-flow: row wrap;
		justify-content: space-between;
		position: relative;
	}
	.f2 input{
		width:49%;
		border: 1px solid lightgray;
		height: 28px;
	}
	.f1{
		width:100%;
		position: relative;
	}
	.f1 pre{
		width: 100%;
		clear:both;
	}
	.f1 button{
		position : absolute;
		right:0px;
		top:0;
	}
	.f1 .btn1{
		right: 40px;
	}
	.f1 pre{
		line-height:30px;
	}
</style>
<body>
<div class="wrap">
<%
	DaoGB dao = new DaoGB();
	Vector<DtoGB> list = dao.getList();
%>
<c:forEach var="list" items="<%=list%>">
				<div class="f1">
				<span>${list.id}</span>
				<small style="color:gray"> | <fmt:formatDate value="${list.regdate}" pattern="yyyy.MM.dd hh:mm"/> | </small>
				<small>신고</small>
				<button class="btn1" onclick="location.href='guestbookUpdate.jsp?key=${list.idx}'">수정</button>
				<button class="btn2" onclick="location.href='guestbookDelete.jsp?key=${list.idx}'">삭제</button>
				<pre>${list.content}</pre>
			</div>
</c:forEach>
	<form action="guestbookInsertProc.jsp" method="post">
		<div class="f2">
			<textarea name="content" rows="5" placeholder="댓글을 입력해주세요"></textarea>
			<input type="text" name="id" placeholder="이름">
			<input type="password" name="pw" placeholder="비밀번호">
		</div>
			<input type="submit" value="등록">
	</form>
</div>
</body>
</html>