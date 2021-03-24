<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	ul{
		display: flex;
		border : 1px solid black; 
		justify-content : space-around;
		padding:0;
	}
	li{
		list-style : none;
	}
	div{
		border : 1px solid red;
		height: 500px;
	}
	input{
		width: 100px;
	}
	.img{
		width: 500px;
		margin : 0 auto;
		border : 1px solid black;
		position : relative;
	}
	.img img{
		width: 100%;
		
	}
	table{
		margin: 0 auto;
		width: 500px;
		text-align: center;
		border-collapse: collapse;
	}
	td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	
	<ul>
		<li><a href="jsp6.jsp?val=menu1">메뉴1</a></li>
		<li><a href="jsp6.jsp?val=menu2">메뉴2</a></li>
		<li><a href="jsp6.jsp?val=menu3">메뉴3</a></li>
	</ul>
