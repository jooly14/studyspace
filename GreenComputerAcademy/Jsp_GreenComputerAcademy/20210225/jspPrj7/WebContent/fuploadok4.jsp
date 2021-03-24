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
	int maxMemorySize = 1024*1024; //����ũ��
	
	if(isMultipart){
		//��������
		//DiskFileUpload dfu = new DiskFileUpload();
		//�ֽŹ���
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemorySize);
		factory.setRepository(tmpFolder);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(maxFileSize);
		//���ε� �غ� ��
		
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()){
			FileItem fitem = iter.next();
			if(fitem.isFormField()){
				out.print("�Ϲ�Ÿ�� :"+fitem.getFieldName()+"<br>");
			}else{
				out.print("���� : "+fitem.getFieldName()+"<br>");
				out.print("�뷮 : "+fitem.getSize()+"<br>");
				if(fitem.getSize()>0){
					int idx = fitem.getName().lastIndexOf("\\");
					if(idx==-1){
						idx = fitem.getName().lastIndexOf("/");
					}
					String filename = fitem.getName().substring(idx+1);
					//��θ� �����ϰ� ���ϸ� �ҷ�����
					String path = getServletContext().getRealPath("/upload");
					File f = new File(path,filename);
					fitem.write(f);
				}
			}
		}
	}else{
		out.println("��Ƽ��Ʈ�� �۾��ϼ���");
	}
%>
</body>
</html>