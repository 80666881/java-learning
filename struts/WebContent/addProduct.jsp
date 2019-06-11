<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<form action="addProduct">

    <input type="text" name="product.name" value="${param.name}">
    <br/>
    <input type="submit" value="submit">
</form>
</html>