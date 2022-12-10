<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Sign Up</title>
  </head>
  <body>
    <span>Enter your information</span>
    <br />
    <form action="/overview-jsp/user/new" method="post">
      <input type="text" name="username" placeholder="Username :" />
      <br>
      <input type="password" name="password" placeholder="Password : " />
      <br>
      <input type="email" name="email" placeholder="Email..." />
      <br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
