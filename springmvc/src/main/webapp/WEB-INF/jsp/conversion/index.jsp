<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>转换</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/conversion/customDate" method="post">
    时间：<input type="text" name="date" value="2017-10-18 17:09:00"> <br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
