<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	ó�� ������ jsp
	<%
		//����� �ڹ��ڵ带 �ۼ��� �� ����մϴ�.
		//��ũ��Ʈ���̶�� �θ�
		String str = "���ڿ�";
		//out.println("<br>"+str);
		
		for(int i=0;i<10;i++){
			//out.println("<div style='color:red'>"+i+"</div>");
		
	%>
		<div style='color:red'><%=i%></div>
	<%
		}
	%>
	
</body>
</html>