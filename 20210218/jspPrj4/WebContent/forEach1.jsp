<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HashMap<String, Object> mapData = new HashMap<>();
	mapData.put("name", "�ֹ���");
	mapData.put("today", new Date());
%>
<c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>" />
<c:set var="intArray2" value="${[1,2,3,4,5]}" />
<c:set var="map" value="<%=mapData%>" />
<c:set var="map2" value="${{'name':'ȫ�浿','age':'15'}}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h4>1���� 100������ Ȧ���� ��</h4>
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${sum +i}" />
	</c:forEach>
	��� = ${sum}
	
<h4>������ 4��</h4>
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>4 * ${i} = ${i*4}</li>
		</c:forEach>
	</ul>
	
<h4>int�� �迭</h4>
	<c:forEach var="i" items="${intArray}" begin="2" end="4" varStatus="status">
		${status.index } - ${status.count } - [${i}]<br>
	</c:forEach>
<h4>int�� el �迭</h4>
	<c:forEach var="i" items="${intArray2}" begin="1" varStatus="status">
		${status.index } - ${status.count } - [${i}]<br>
	</c:forEach>
	
<h4>Map</h4>
	<c:forEach var="i" items="${map}">
		${i.key} = ${i.value }<br>
	</c:forEach>	
<h4>Map el</h4>
	<c:forEach var="i" items="${map2}">
		${i.key} = ${i.value }<br>
	</c:forEach>	
</body>
</html>