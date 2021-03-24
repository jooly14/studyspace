<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<%
		String red = "255";
		String green = "255";
		String blue = "255";
		if(request.getParameter("r")!=null){
			red = request.getParameter("red");
		}
		if(request.getParameter("g")!=null){
			green = request.getParameter("green");
		}
		if(request.getParameter("b")!=null){
			blue = request.getParameter("blue");
		}
	%>
<body style="background-color:rgb(<%=red%>,<%=green%>,<%=blue%>)">

</body>
</html>