<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>Login</title></head>
<body>
    <form action="/user" method="post">
        Enter your information
        <input type="text" name="username">
        <br>
        <input type="password" name="password">
        <br>
        <input type="submit" value="Sign in">
    </form>
</body>
</html>