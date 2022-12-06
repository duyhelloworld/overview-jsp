<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>JSP</title></head>
<body>
    <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
    <br>
    <a href="form.jsp">Click to sign up</a>
</body>
</html>