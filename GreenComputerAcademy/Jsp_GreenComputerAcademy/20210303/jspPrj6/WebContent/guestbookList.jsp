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
		margin-top:10px;
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
		line-height:25px;
	}
	.f1 button{
		position : absolute;
		right:0px;
		top:0;
	}
	.f1 .btn1{
		right: 40px;
	}
	.f2 textarea{
		margin-bottom:10px;
	}
	.f1 .btn0{
		right: 40px;
	}
	.f3{
		clear:both;
		display:flex;
		justify-content: center;
		margin-top:100px;
		align-items: center;
	}
	.f3 input[type="submit"]{
		float:none;
		margin:0;
		height: 23px;
		width:40px;
	}
	.f4{
		display:flex;
		justify-content: center;
	}
	/* .f3 input[type="search"]{
		height:23px;
	} */
	a{
		text-decoration: none;
	}
</style>
<body>
<div class="wrap">
<%
	String sort = request.getParameter("sort");
	String find = request.getParameter("find");
	String curPage = request.getParameter("p");
	if(curPage==null) curPage = "1";
	DaoGB dao = new DaoGB();
	dao.setPageNumber(Integer.parseInt(curPage)-1);
	Vector<DtoGB> list = dao.getList(sort,find);
	int cnt = dao.getCnt();
	int totalPage = dao.calcTotalPage();
	int start = 0;
	if(Integer.parseInt(curPage)%5 ==0){
		start = (Integer.parseInt(curPage)/5-1)*5+1;
	}else{
		start = (Integer.parseInt(curPage)/5)*5+1; 
	}
%>
<c:set var="totalPage" value="<%=totalPage%>"></c:set>
<c:set var="curpage" value="<%=Integer.parseInt(curPage)%>"></c:set>
<c:set var="start" value="<%=start%>"></c:set>
<c:forEach var="list" items="<%=list%>">
	<div class="f1">
		<span>${list.id}</span>
		<small style="color:gray"> | <fmt:formatDate value="${list.regdate}" pattern="yyyy.MM.dd hh:mm:ss"/> | </small>
		<small>신고</small>
		<button class="btn0" onclick="window.open('guestbookUpdate.jsp?key=${list.idx}','_blink' ,'width=600, height=250, menubar=no, status=no, toolbar=no')">수정</button>
		<button class="btn3" onclick="window.open('guestbookDelete.jsp?key=${list.idx}','_blink','width=400, height=50, menubar=no, status=no, toolbar=no')">삭제</button>
		<%-- <button class="btn1" onclick="location.href='guestbookUpdate.jsp?key=${list.idx}'">수정</button> --%>
		<%-- <button class="btn2" onclick="location.href='guestbookDelete.jsp?key=${list.idx}'">삭제</button> --%>
		<pre style="border-bottom:1px solid black">${list.content}</pre>
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
		<form action="guestbookList.jsp" method="get">
	<div class="f3">
			<select name="sort">
				<option value="name" selected>이름</option>
				<option value="con">내용</option>
			</select>
			<input type="search" name="find"><input type="submit" value="검색">
	</div>
		</form>
		<div class="f4">
			<c:if test="${curpage>5}">
				<button onclick="location.href='guestbookList.jsp?p=<%=start-1%>&sort=${param.sort}&find=${param.find}'">&lt;</button>
			</c:if>	
			<c:forEach var="i" begin="${start}" end="${start+4<totalPage?start+4:totalPage}">
				<a style="color:${curpage == i?'red':'black'}" href="guestbookList.jsp?p=${i}&sort=${param.sort}&find=${param.find}">[${i}]</a>
			</c:forEach>
			<c:if test="${start+4<totalPage}">
				<button onclick="location.href='guestbookList.jsp?p=<%=start+5%>&sort=${param.sort}&find=${param.find}'">&gt;</button>
			</c:if>
		</div>
</div>
</body>
</html>