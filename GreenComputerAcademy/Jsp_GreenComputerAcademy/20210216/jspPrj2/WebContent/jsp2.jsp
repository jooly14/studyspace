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
		HttpServletRequest httpRequest = (HttpServletRequest)pageContext.getRequest();
	%>
	
	<%=request == httpRequest %>
	<br>
	
	<%pageContext.getOut().println("�ȳ��ϼ���!!"); %>
	<br>
	
	�������� : <%=application.getServerInfo() %><br>
	���� �Ծ� ������ ���� : <%=application.getMajorVersion() %><br>
	���� �Ծ� ���̳� ���� : <%=application.getMinorVersion() %>
</body>
</html>