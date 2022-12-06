<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>JSP</title></head>
<body>
    <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
</body>
</html>