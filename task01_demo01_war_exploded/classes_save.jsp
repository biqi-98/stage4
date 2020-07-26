<%--
  Created by IntelliJ IDEA.
  User: biqi
  Date: 2020-07-25
  Time: 23:47
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
    <title>保存班級页面</title>

</head>


<body>

<h3>保存班級页面</h3>

<form method="post" action="ClassesSaveServlet">
    <input type="hidden" name="cid" value="${classes.id }">
    <table border="1" width="600">

        <tr>
            <td>班级名称</td>
            <td><input type="text" name="cname" value="${classes.name }"></td>
        </tr>
        <tr>
            <td>年级</td>
            <td><input type="text" name="grand" value="${classes.grand }"></td>
        </tr>
        <tr>
            <td>班主任名称</td>
            <td><input type="text" name="headmaster" value="${classes.headmaster }"></td>
        </tr>
        <tr>
            <td>教室位置</td>
            <td><input type="text" name="seat" value="${classes.seat }"></td>
        </tr>
        <tr>
            <td>班级口号</td>
            <td><textarea type="text" name="slogan" >${classes.slogan }</textarea></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="保存"> </td>
        </tr>
    </table>
</form>
</body>
</html>
