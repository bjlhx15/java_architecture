<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello world,Customer</h2>
<%@page import="com.github.bjlhx15.architecture.customermgr.Customer1" %>
<%
    System.out.println("now in Customermgr c1.jsp");
    new Customer1().c1("yemian c1");
%>
</body>
</html>
