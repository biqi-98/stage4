<%--
  Created by IntelliJ IDEA.
  User: biqi
  Date: 2020-07-17
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>保存学生页面</title>

</head>


<body>

<h3>保存学生页面</h3>

<form method="post" action="SaveServlet">
    <input type="hidden" name="sid" value="${stu.id }">
    <table border="1" width="600">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="sname" value="${stu.name }"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男" <c:if test="${stu.sex == '男'}">checked</c:if>>男
                <input type="radio" name="sex" value="女" <c:if test="${stu.sex == '女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="date" name="birthday" value="${stu.birthday }"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email" value="${stu.email }"></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><textarea name="remark" rows="3" cols="20">${stu.remark }</textarea></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="保存"> </td>
        </tr>
    </table>
</form>
</body>
</html>
