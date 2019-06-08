<%--
  Created by IntelliJ IDEA.
  User: zeller
  Date: 2019-06-05
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%
    List<String> words = new ArrayList<String>();
    words.add("11today");
    words.add("is");
    words.add("a");
    words.add("great");
    words.add("day");
%>

<table width="200px" align="center" border="1" cellspacing="0">

    <%for (String word : words) {%>

    <tr>
        <td><%=word%></td>
    </tr>

    <%}%>

</table>
<%@include file="footer.jsp" %>