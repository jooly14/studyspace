<%@page import="com.joo.dao.BDao"%>
<%@page import="com.joo.dto.BDto"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page ="lmain.jsp" />
<%
	String curpage = request.getParameter("page");
	if(curpage == null){
		curpage = "1";
	}
	int curp = Integer.parseInt(curpage);
	int start = 0;
	if(curp%5==0){
		start = curp-4;
	}else{
		start = (curp/5)*5+1;
	}
	BDao dao = new BDao();
	dao.setCurPage(curp);	
	Vector<BDto> v = dao.getList();
	int totalp = dao.getTotalPage();
%>
<c:set var="start" value="<%=start%>" />
<c:set var="curp" value="<%=curp%>" />
<c:set var="totalp" value="<%=totalp%>" />
<c:set var="v" value="<%=v%>"/>
	<table border="1"> 
		<tr>
			<td>글번호</td>		
			<td>제목</td>		
			<td>아이디</td>		
			<td>작성시간</td>		
			<td>조회수</td>		
		</tr>
<%
	if(v.size()==0){
%>
	<tr>
		<td colspan="5">데이터가 없습니다</td>
	</tr>
<%}else{ %>		
<c:forEach var="i" items="${v}">
		<tr>
			<td>${i.idx}</td>		
			<td><a href="bread.jsp?idx=${i.idx}">${i.title}</a></td>		
			<td>${i.id}</td>		
			<td>${i.regdate}</td>		
			<td>${i.hit}</td>		
		</tr>
</c:forEach>
<%} %>
	</table>
	<input type="button" value="글쓰기" onclick="location.href='bwrite.jsp'">
	<div>
		<c:if test="${curp>5}">
			<input type="button" value="&lt;" onclick="location.href='bmain.jsp?page=${start-1}'">
		</c:if>
		<c:forEach var="i" begin="${start}" end="${start+5<=totalp?start+4:totalp}">
			<a style="color:${curp eq i? 'orange' : 'black'}" href="bmain.jsp?page=${i}">${i}</a>
		</c:forEach>
		<c:if test="${start+5<=totalp}">
			<input type="button" value="&gt;" onclick="location.href='bmain.jsp?page=${start+5}'">
		</c:if>
	</div>
</body>
</html>