<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Sign Up</title>
  </head>
  <body>
    <span>Enter your information</span>
    <br />
    <form action="/overview-jsp/user" method="post">
      <input type="text" name="username" placeholder="Username :" />
      <br>
      <input type="password" name="password" placeholder="Password : " />
      <br>
      <input type="email" name="email" placeholder="Email..." />
      <br>
      <label for="favourite">Favourite</label>
      <ul>
        <li>
          Listen Music : <input type="checkbox" name="favourite1" value="Listen Music"/>
        </li>
        <li>
          Watch Film : <input type="checkbox" name="favourite2" value="Watch Film"/>
        </li>
        <li>
         Play Game : <input type="checkbox" name="favourite3" value="Play Game" />
        </li>
        <li>
          Read Books : <input type="checkbox" name="favourite4" value="Read Books"/>
        </li>
      </ul>

      <br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
