<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
  <head>
    <title>View</title>
  </head>
  <body>
    <%!
    String favSolve(String fav, String v_fav){
        if(v_fav != null) {
            if(fav == ""){
                return v_fav;
            }
            return fav + ", " + v_fav;
        }
        return fav;
    }
    %>
    <%
    String username = request.getParameter("username"); 
    String password = request.getParameter("password"); 
    String email = request.getParameter("email"); 
    String favourite1 = request.getParameter("favourite1"); 
    String favourite2 = request.getParameter("favourite2"); 
    String favourite3 = request.getParameter("favourite3"); 
    String favourite4 = request.getParameter("favourite4");
    
    String fav = "";
    fav = favSolve(fav, favourite1);
    fav = favSolve(fav, favourite2);
    fav = favSolve(fav, favourite3);
    fav = favSolve(fav, favourite4);
    %>

    You've sign up. Your information is <br />
    <ul>
      <li>
        <span>Username : <%= username%></span>
      </li>
      <li>
        <span>Email : <%= email%></span>
      </li>
      <li>
        <span>Favourite : </span>
        <%= fav%>
      </li>
  </body>
</html>
