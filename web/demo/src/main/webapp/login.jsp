<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
  <div>
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" required>
  </div>
  <div>
    <br>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password" required>
  </div>
  <br>
  <button type="submit">Submit</button>
</form>
</body>
</html>

