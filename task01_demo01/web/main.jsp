<%@ page import="com.lagou.demo01.bean.User" %><%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<h1>登录成功，欢迎<%= ((User)session.getAttribute("user")).getUserName() %>使用！</h1>

<h3><a href="StudentListServlet">显示所有学生列表</a></h3><br>
<h3><a href="StudentListPageServlet?currentPage=1">显示学生</a></h3>
</body>
</html>
