<%@page import="com.joo.dto.DtoLo"%>
<%@page import="java.util.Vector"%>
<%@page import="com.joo.dao.DaoLo"%>
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
<!--
CREATE TABLE USER(
   idx INT PRIMARY KEY AUTO_INCREMENT, 
   id VARCHAR(50) UNIQUE NOT NULL,
   pw VARCHAR(100) NOT NULL,
   NAME VARCHAR(50) NOT NULL,
   email VARCHAR(100) NOT NULL,
   tel VARCHAR(20) NOT NULL,
   addr VARCHAR(200) NOT NULL,
   birth DATE NOT NULL,
   gender CHAR(1) NOT NULL,
   nation VARCHAR(10) NOT NULL, 
   interest1 VARCHAR(50),
   interest2 VARCHAR(50),
   interest3 VARCHAR(50),
   findpw1 VARCHAR(200) NOT NULL,
   findpw2 VARCHAR(200) NOT NULL,
   findpw3 VARCHAR(200) NOT NULL,
   findas1 VARCHAR(200) NOT NULL,
   findas2 VARCHAR(200) NOT NULL,
   findas3 VARCHAR(200) NOT NULL,
   regdate DATE
);
  -->
��ü ȸ�� ����<input type="button" value="ȸ������" onclick="location.href='lreg.jsp'">
<table border="1">
<%
	DaoLo dao = new DaoLo();
	Vector<DtoLo> v = dao.getList();
	if(v.size()==0){
%>
	<tr>
		<td>������ �����ϴ�.</td>
	</tr>
<%	}else{ %>
	<tr>
		<td>��ȣ</td><td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>��ȭ��ȣ</td><td>�ּ�</td><td>����</td><td>����</td><td>����</td><td>���ɻ�1</td><td>���ɻ�2</td><td>���ɻ�3</td><td>����1</td><td>��1</td><td>����2</td><td>��2</td><td>����3</td><td>��3</td><td>������</td>
	</tr>
<c:forEach var="v" items="<%=v%>">
	<tr>
		<td>${v.idx}</td><td>${v.id}</td><td>${v.pw}</td><td>${v.name}</td><td>${v.email}</td><td>${v.tel}</td><td>${v.addr}</td><td>${v.birth}</td><td>${v.gender}</td><td>${v.nation}</td><td>${v.interest[0]}</td><td>${v.interest[1]}</td><td>${v.interest[2]}</td><td>${v.findpw1}</td><td>${v.findas1}</td><td>${v.findpw2}</td><td>${v.findas2}</td><td>${v.findpw3}</td><td>${v.findas3}</td><td>${v.regdate}</td>
	</tr>
</c:forEach>
	
<%	}%>

</table>
</body>
</html>