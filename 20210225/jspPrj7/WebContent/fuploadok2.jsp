<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="com.oreilly.servlet.*" %>
<!-- http://www.servlets.com/cos/ ���� ���ε� jar ���� �ٿ�ε� -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	
	
	//���� ������ ���ε�� ������
	String path = request.getServletContext().getRealPath("/upload");
	File file = new File(path);
	if(!file.isDirectory()){
		file.mkdir();
	}
	
	String enc = "utf-8";
	int maxSize = 1024*1024*10; //10�ް�
	MultipartRequest mrequest = new MultipartRequest(request,path,maxSize,enc,new DefaultFileRenamePolicy());
	//���� ���ε� ��
	
	//���ε� ���� ���
	String txt = mrequest.getParameter("txt");
	//������ ���� ������ ����Ǿ��� �� ���ϸ�
	String file1 = mrequest.getFilesystemName("file1");
	String file2 = mrequest.getFilesystemName("file2");
	
	//������ ���ε尡 �ɶ� �Ѿ�� ���ϸ�
	String originFile1 = mrequest.getOriginalFileName("file1");
	String originFile2 = mrequest.getOriginalFileName("file2");
	
%>
<%=txt %><br>
<%=file1 %><br>
<%=file2 %><br>
<%=originFile1 %><br>
<%=originFile2 %><br>
<img src="upload/<%=file1%>">
</body>
</html>