<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	File tmpFolder = new File("/tmp");
	int maxFileSize = 1024*1024*10;
	int maxMemorySize = 1024*1024; //버퍼크기
	
	if(isMultipart){
		//이전버전
		//DiskFileUpload dfu = new DiskFileUpload();
		//최신버전
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemorySize);
		factory.setRepository(tmpFolder);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(maxFileSize);
		//업로드 준비 끝
		
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()){
			FileItem fitem = iter.next();
			if(fitem.isFormField()){
				out.print("일반타입 :"+fitem.getFieldName()+"<br>");
			}else{
				out.print("파일 : "+fitem.getFieldName()+"<br>");
				out.print("용량 : "+fitem.getSize()+"<br>");
				if(fitem.getSize()>0){
					int idx = fitem.getName().lastIndexOf("\\");
					if(idx==-1){
						idx = fitem.getName().lastIndexOf("/");
					}
					String filename = fitem.getName().substring(idx+1);
					//경로를 제외하고 파일명만 불러오기
					String path = getServletContext().getRealPath("/upload");
					File f = new File(path,filename);
					fitem.write(f);
				}
			}
		}
	}else{
		out.println("멀티파트로 작업하세요");
	}
%>
</body>
</html>