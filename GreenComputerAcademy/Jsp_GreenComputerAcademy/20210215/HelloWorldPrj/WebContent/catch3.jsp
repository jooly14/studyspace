<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String ga = request.getParameter("garo");
	String se = request.getParameter("sero");
	String color = request.getParameter("color");
	String xy_ = request.getParameter("xy");
	String cnt_ = request.getParameter("cnt");
	String[] xys = xy_.split(",");
	int cnt = Integer.parseInt(cnt_);
	int x = Integer.parseInt(xys[0]);
	int y = Integer.parseInt(xys[1]);
	for(int i=0;i<cnt;i++){
		%>
		
		<div style="background-color:<%=color%>;border:2px solid black;position:absolute;display:inline-block;width:<%=ga%>px;height:<%=se%>px;top:<%=y%>px;left:<%=x%>px"></div>
		<%
		x += Integer.parseInt(ga);
	}
	
%>

</body>
</html>