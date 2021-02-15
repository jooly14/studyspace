<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	span{
	 display: inline-block;
	 width:100px;
	}
</style>
</head>
<body>
	<%
		for(int i=1;i<10;i++){
			for(int j=2;j<10;j++){
				if(j%2==0){
	%>
				<span style='color:red'><%=j%>x<%=i%>=<%=j*i%></span>
	<%
				}else{
	%>
				<span style='color:blue'><%=j%>x<%=i%>=<%=j*i%></span>
	<%	
				}
			}
			out.println("<br>");
		}
	%>
</body>
</html>