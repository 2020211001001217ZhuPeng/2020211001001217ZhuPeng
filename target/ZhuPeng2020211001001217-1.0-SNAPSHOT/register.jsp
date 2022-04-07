<%--
  Created by IntelliJ IDEA.
  User: 朱鹏
  Date: 2022/3/12
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>--%>
<%@include file="header.jsp"%>
This is my register JSP page.<br><br>
<form method="post" action="register">
    Id:<input type="text" name="id"/><br/>
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    Email:<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth:<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
<%--</body>
</html>--%>
<%@include file="footer.jsp"%>