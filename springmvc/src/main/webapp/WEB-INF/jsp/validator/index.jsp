<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hibernate-validator 数据校验</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/validator/login2"
      method="post">
    用户名：<input type="text" name="username" value=${user.username}> <span>${usernameValid}</span><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" value=${user.password}><span>${passwordValid}</span><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
