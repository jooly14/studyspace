<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="com.oreilly.servlet.*" %>
<!-- http://www.servlets.com/cos/ 파일 업로드 jar 파일 다운로드 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	
	
	//실제 파일이 업로드될 폴더명
	String path = request.getServletContext().getRealPath("/upload");
	File file = new File(path);
	if(!file.isDirectory()){
		file.mkdir();
	}
	
	String enc = "utf-8";
	int maxSize = 1024*1024*10; //10메가
	MultipartRequest mrequest = new MultipartRequest(request,path,maxSize,enc,new DefaultFileRenamePolicy());
	//파일 업로드 끝
	
	//업로드 정보 출력
	String txt = mrequest.getParameter("txt");
	//파일이 실제 서버에 저장되었을 때 파일명
	String file1 = mrequest.getFilesystemName("file1");
	String file2 = mrequest.getFilesystemName("file2");
	
	//파일이 업로드가 될때 넘어온 파일명
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