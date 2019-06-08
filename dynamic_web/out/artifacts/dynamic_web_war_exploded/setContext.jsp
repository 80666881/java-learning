<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    request.setAttribute("name","gareen");
%>

<%=request.getAttribute("name")%>
<jsp:forward page="getContext.jsp"/>