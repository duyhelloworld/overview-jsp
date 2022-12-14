<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <div class="box-role">
      Your Role : <br />
      <button id="role_user_btn">User</button>
      <button id="role_admin_btn">Admin</button>
    </div>
    <div class="admin">
      <form action="/overview-jsp/user/login" method="post">
        <input type="hidden" name="role" value="admin">
        <span>Admin</span> <br>
        Enter your information <br />
        <input type="text" name="username" placeholder="Admin Account..." />
        <br />
        <input type="password" name="password" />
        <br />
        <input type="submit" value="Sign in" />
      </form>
    </div>
    <div class="user">
      <form action="/overview-jsp/user/login" method="post">
        <input type="hidden" name="role" value="user">
        <span>User</span> <br>
        Enter your information <br />
        <input type="text" name="username" placeholder="Username..." />
        <br />
        <input type="password" name="password" />
        <br />
        <input type="submit" value="Sign in" />
      </form>
    </div>

  </body>
  <style>
    .hidden {
      display: none;
    }
    .visible {
      display: block;
    }
    .admin span,  #role_admin_btn{
      color: red;
    }
    .user span, #role_user_btn {
      color: blue;
    }
    .box-role{
      float: right;
      padding: 5%;
    }
    input[type="submit"]{
      background-color: green;
      border: 1px solid gray;
      border-radius: 10px;
      padding: 10px;
      width: 210px;
      margin-top: 5px;
    }
    input[type="submit"]:active{
      background-color: gray;
    }
    
  </style>
  <script>
    const user = document.querySelector(".user");
    const admin = document.querySelector(".admin");

    const userBtn = document.getElementById("role_user_btn");
    const adminBtn = document.getElementById("role_admin_btn");

    admin.classList.add("hidden");
    user.classList.add('visible');

    userBtn.onclick = (e) => {
      if (user.classList.contains('hidden') && admin.classList.contains('visible')) {
        user.classList.remove('hidden');
        user.classList.add('visible');
        admin.classList.remove('visible');
        admin.classList.add('hidden');
      }
    }
    adminBtn.onclick = () => {
      if (admin.classList.contains('hidden') && user.classList.contains('visible')) {
        admin.classList.remove('hidden');
        admin.classList.add('visible');
        user.classList.remove('visible');
        user.classList.add('hidden');
      }
    }
  </script>
</html>
