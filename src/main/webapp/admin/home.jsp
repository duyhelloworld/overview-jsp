<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>Admin</title></head>
<body>
    <form action="/overview-jsp/user/view" method="get">
        <input type="submit" value="View Users">
    </form>
    <span>Home page</span> <br>
    <strong>Admin name : 
        <!-- <%
            String username = request.getParameter("username");
            out.println(username);
        %> -->
    </strong> 
    <script>
        alert("Welcome to admin's page!");
    </script>
</body>
</html>