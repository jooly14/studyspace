<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<jsp:include page="jsp5.jsp" />
	<%
		
		String val = request.getParameter("val");
		if(val==null){
			%>
				<jsp:include page="menu2.jsp"/>
			<%
		}else{
			if(val.equals("menu1")){
				%>
				<jsp:include page="menu1.jsp"/>
				<%
			}else if(val.equals("menu2")){
				%>
				<jsp:include page="menu2.jsp"/>
				<%
			}else if(val.equals("menu3")){
				%>
				<jsp:include page="menu3.jsp"/>
				<%
			}
		}
	%>
	
</body>
</html>