<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>List User</title></head>
<body>
    <%
    if (request.getParameter("username") == "admin" && request.getParameter("password") == "password"){
        
    }
    else {
        response.sendRedirect("/overview-jsp")
    }
    %>
</body>
</html>