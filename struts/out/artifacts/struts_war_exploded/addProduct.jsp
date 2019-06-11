<%--
  Created by IntelliJ IDEA.
  User: zeller
  Date: 2019-06-10
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<body>

<s:form action="addProduct">

    <s:textfield name="product.name" label="product name" />
    <s:submit value="Submit" />

</s:form>

</body>
</html>