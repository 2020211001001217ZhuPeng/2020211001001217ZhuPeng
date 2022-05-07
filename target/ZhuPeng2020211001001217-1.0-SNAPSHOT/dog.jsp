<%@ page import="com.ZhuPeng.week11.Person" %>
<%@ page import="com.ZhuPeng.week11.Dog" %><%--
  Created by IntelliJ IDEA.
  User: 朱鹏
  Date: 2022/5/7
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 2-week11</title>
</head>
<body>
<%
    com.ZhuPeng.week11.Person person=new Person();
    person.setName("Tom");
    Dog dog=new Dog();
    dog.setName("Tommy");
    person.setDog(dog);
    request.setAttribute("personAtt",person);
%>
<h2>get persons' dog name -using java code</h2>
<%
    Person p=(Person) pageContext.findAttribute("personAtt");
    Dog d=p.getDog();
    out.println(p.getName()+"s' Dog name-->"+d.getName());
%>
<h2>get persons' dog name -usingEL code</h2>
Persons' Dog name:${personAtt.name}s' Dog name-->${personAtt.dog.name}
</body>
</html>
