<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>fuploadok1.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
   BufferedReader br
       = new BufferedReader(
        new InputStreamReader(
            request.getInputStream()));
   String str = "";
   while((str=br.readLine())!= null){
      out.println(str+"<br>");
   }
   br.close();      
%>
</body>
</html>


