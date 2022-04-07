<%@ page import="com.ZhuPeng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 朱鹏
  Date: 2022/4/2
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User)request.getAttribute("user");
%>
<table border=1>
    <tr>
<%--        <td>Id:</td><td><%=request.getAttribute("id")%></td>--%>
    <td>Id:</td><td><%=user.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=user.getGender()%></td>
    </tr>
    <tr>
        <td>Birthday:</td><td><%=user.getBirthday()%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
