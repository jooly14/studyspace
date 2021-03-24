<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
   ul{
      display: flex;
      border: 1px solid black;
   }
   li{
      list-style: none;
      border: 1px solid blue;
      margin-right:10px;
   }
   div{
      border: 1px solid red;
      height: 500px;
   }
   input{
      width: 300px;      
   }
   table{
      margin: 0 auto;
      width: 500px;
      text-align: center;
      border-collapse: collapse;
   }
   td{
      border: 1px solid black;
   }
   .img{
      width: 500px;
      margin: 0 auto;
      border: 1px solid black;
      position: relative;
   }
   .img img{
      width: 100%;
      /* 높이는 안주면 자동으로 가로 비율에 맞춰진다. */
   }
</style>
</head>
<body>
   <ul>
      <li><a href="body.jsp?val=menu1">메뉴1</a></li>
      <li><a href="body.jsp?val=menu2">메뉴2</a></li>
      <li><a href="body.jsp?val=menu3">메뉴3</a></li>
   </ul>










