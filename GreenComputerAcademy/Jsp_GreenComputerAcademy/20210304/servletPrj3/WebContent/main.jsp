<%@page import="mvc.dto.MDto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty sessionScope.authid}"><a href="controller?cmd=signup">회원가입</a> <a href="controller?cmd=signinform">로그인</a></c:if>
<c:if test="${!empty sessionScope.authid}">${sessionScope.authid}님 환영합니다. <a href="controller?cmd=moduserform">회원정보 수정</a> <a href="controller?cmd=signout">로그아웃</a><br>
</c:if>
<%
	int curpage = Integer.parseInt((String)request.getAttribute("page"));
	int start = (curpage/5)*5+1;
	if(curpage%5==0){
		start = (curpage/5-1)*5+1;
	}
	//int totalcnt = Integer.parseInt((String)request.getAttribute("totalcnt"));
	int totalpage = (Integer)request.getAttribute("totalpage");
%>
<c:set var="start" value="<%=start%>" />
<c:set var="curpage" value="<%=curpage%>" />
<c:set var="totalpage" value="<%=totalpage%>" />
<table border="1">
<tr>
	<td>번호</td>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
	<td>삭제</td>
</tr>
<c:forEach var="v" items="${result}">
	<tr>
	 	<td>${v.idx}</td>
		<td>${v.id}</td>
		<td>${v.pw}</td>
		<td>${v.name}</td> 
		<td><c:if test="${sessionScope.authid eq v.id}"><a href="controller?idx=${v.idx}&cmd=del">삭제</a></c:if></td>
	</tr>	
</c:forEach>
</table>
<div>
	<c:if test="${start ne 1}">
		<a href="controller?page=${start-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${start}" end="${start+4<totalpage?start+4:totalpage}">
		<a style="color:${i eq curpage?'orange':'black'}" href="controller?page=${i}">${i}</a>
	</c:forEach>
		<c:if test="${start+4<totalpage}">
		<a href="controller?page=${start+5}">[다음]</a>
	</c:if>
</div>
</body>
</html>