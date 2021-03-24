<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>선언부를 사용한 두 정수값의 곱</title>
</head>
<body>
	<%! 
		public int multiply(int a, int b){
			int c = a * b;
			return c;
		} 
	%>
	10 X 25 = <%=multiply(10,25) %>
</body>
</html>