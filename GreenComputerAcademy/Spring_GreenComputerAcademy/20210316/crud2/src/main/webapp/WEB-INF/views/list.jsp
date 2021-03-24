<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
THIS IS LIST PAGE<br>
*** ${result} ***<br>
*** ${cnt} ***<br>
<table>
<c:forEach var="dummy" items="${list}">
	<tr>
		<td>${dummy.num}</td>
		<td>${dummy.id}</td>
		<td>${dummy.pw}</td>
		<td>${dummy.content}</td>
		<td><a href="${path}${dummy.sfile}" download>${dummy.ofile}</a></td>
		<td><a href="delete?num=${dummy.num}">삭제</a></td>
		<td><a href="update?num=${dummy.num}">수정</a></td>
	</tr>
</c:forEach>
</table>
	<a href="insert">입력</a>
<div>
	<c:if test="${start >= 5}">
		<a href="list?page=${start-1}">이전</a>
	</c:if>
	<c:forEach var="i" begin="${start}" end="${end}">
		<a style="color:${i==page?'orange':'black'}" href="list?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${end < totalpage}">
		<a href="list?page=${end+1}">다음</a>
	</c:if>
</div>
</body>
</html>