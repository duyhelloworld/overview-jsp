<form%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head><title>JSP</title></head>
<body>
    <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
    <span style="text-align: center;">Home Page</span>
    <br>
    <%
        Cookie[] useCookies = request.getCookies();
                    if (!userCookies.equals(null)) {
                        for (Cookie userCk : userCookies) {
                            String userCk_user = userCk.getName();
                            String userCK_pass = userCk.getValue();
                            if (DAO_User.validate(userCk_user, userCK_pass)) {
                                out.println("OK, tk");
                                break;
                            }
                        }
                    }
                    else {
                        out.println("Not tk");
                    }
    %>
</body>
</html>