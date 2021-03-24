<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
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
		char[] buff = new char[128];
		int len = -1;
		
		String filePath = application.getRealPath("/message/notice.txt");
		InputStreamReader fr = new InputStreamReader(new FileInputStream(filePath),"EUC-KR");
			while((len = fr.read(buff))!=-1){
				out.println(new String(buff,0, len));
			}
		fr.close();
	%>
</body>
</html>