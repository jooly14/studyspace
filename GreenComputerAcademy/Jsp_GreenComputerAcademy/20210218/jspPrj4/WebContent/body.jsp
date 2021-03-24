<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!-- 넘어오는 request에 따라서 페이지가 바뀜 -->   

    디렉티브를 이용한 인크루드
   <%@ include file="header.jsp" %>
   
<%--    ${param.val}
  <%
   
      String val = request.getParameter("val");
       if(val==null){%>      
      <jsp:include page="menu2.jsp"/>
   <%  }else if(val.equals("menu1")){%>
      <jsp:include page="menu1.jsp"/>
   <%   }else if(val.equals("menu2")){%>
      <jsp:include page="menu2.jsp"/>
   <%  }else if(val.equals("menu3")){%>
      <jsp:include page="menu3.jsp"/>
   <%   } %> --%>
<c:choose>
	<c:when test="${empty param.val}">
		 <jsp:include page="menu2.jsp"/>
	</c:when>
	<c:when test="${param.val eq 'menu1'}">
		 <jsp:include page="menu1.jsp"/>
	</c:when>
	<c:when test="${param.val eq 'menu2'}">
		 <jsp:include page="menu2.jsp"/>
	</c:when>
	<c:when test="${param.val eq 'menu3'}">
		 <jsp:include page="menu3.jsp"/>
	</c:when>
</c:choose>
   
   
</body>
</html>




