<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>JSP</title></head>
<body>
    <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
    <span style="text-align: center;">Home Page</span>
    <br>
    <a href="/overview-jsp/user/signup">Click to sign up</a>
    <a href="/overview-jsp/user/signin">Click to sign in</a>
</body>
</html>