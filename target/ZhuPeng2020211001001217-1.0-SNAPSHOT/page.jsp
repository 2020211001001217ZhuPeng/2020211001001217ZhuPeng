<%--
  Created by IntelliJ IDEA.
  User: 朱鹏
  Date: 2022/5/2
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo#1-Week 10</title>
</head>
<body>
<h2>Use of pageContext to set,get,remove attribute from 4 scopes:page,request,session,application</h2>
<%
    //set attribute in page,request,session,application
    pageContext.setAttribute("attName","in page");
    request.setAttribute("attName","in request");
    session.setAttribute("attName","in session");
    //application.setAttribute("attName","in application");//use implicit object
    //set attribute-using page context
    pageContext.setAttribute("attName","in application",PageContext.APPLICATION_SCOPE);
%>
<h2>Get attribute using implicit objects -way1</h2>
Att Value:<%=pageContext.getAttribute("attName")%><br>
Att Value:<%=request.getAttribute("attName")%><br>
Att Value:<%=session.getAttribute("attName")%><br>
Att Value:<%=application.getAttribute("attName")%><br>

<h2>Get attribute using pageContext -way2</h2>
Att Value:<%=pageContext.getAttribute("attName",PageContext.PAGE_SCOPE)%><br>
Att Value:<%=pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE)%><br>
Att Value:<%=pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)%><br>
Att Value:<%=pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE)%><br>

<h2>Use findAttribute of pageContext-search -page-request-session-application-Null</h2>
Att Value:<%=pageContext.findAttribute("attName")%>
</body>
</html>
