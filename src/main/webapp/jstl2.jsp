<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ZhuPeng.week11.Dog" %>
<%@ page import="com.ZhuPeng.week11.Person" %><%--
  Created by IntelliJ IDEA.
  User: 朱鹏
  Date: 2022/5/14
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl2</title>
</head>
<body>
<h2>use c:set to set bean property</h2>
<%
        Person p=new Person();
        Dog d=new Dog();
        request.setAttribute("p",p);
        request.setAttribute("d",d);
%>
<c:set target="${p}" property="name" value="person1"/>
<c:set target="${d}" property="name" value="dog1"/>
<c:set target="${p}" property="dog" value="${d}"/>
Dog Name:<c:out value="${p.dog.name}"/>
</body>
</html>
