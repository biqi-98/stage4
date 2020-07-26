<%--
  Created by IntelliJ IDEA.
  User: biqi
  Date: 2020-07-25
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>班級列表页面</title>

    <script type="text/javascript">

        function doDelete(cid) {
            /* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。
            如何知道用户点击的是确定。
            如何在js的方法中请求servlet。 */
            var flag = confirm("是否确定删除?");
            if(flag){
                //表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
                location.href="ClassesDeleteServlet?deleteId="+cid;
            }
        }
    </script>

</head>
<body>
<form action="ClassesListPageServlet" method="post">
    <table border="1" width="700">

        <tr >
            <td colspan="8">
                &nbsp;&nbsp;&nbsp;
                <a href="classes_save.jsp">添加</a>
            </td>
        </tr>

        <tr align="center">
            <td>编号</td>
            <td>班级名称</td>
            <td>年级</td>
            <td>班主任名称</td>
            <td>教室位置</td>
            <td>班级口号</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${pageBean.list }" var="classes">
            <tr align="center">
                <td>${classes.id }</td>
                <td>${classes.name }</td>
                <td>${classes.grand }</td>
                <td>${classes.headmaster }</td>
                <td>${classes.seat }</td>
                <td>${classes.slogan }</td>
                <td><a href="ClassesEditServlet?cid=${classes.id }">更新</a>   <a href="#" onclick="doDelete(${classes.id})">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8">
                第 ${pageBean.currentPage } / ${pageBean.totalPage }
                &nbsp;&nbsp;
                每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
                总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
                <c:if test="${pageBean.currentPage !=1 }">
                    <a href="ClassesListPageServlet?currentPage=1">首页</a>
                    | <a href="ClassesListPageServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
                </c:if>

                <c:forEach begin="1" end="${pageBean.totalPage }" var="i">
                    <c:if test="${pageBean.currentPage == i }">
                        ${i }
                    </c:if>
                    <c:if test="${pageBean.currentPage != i && pageBean.currentPage-i<3&&pageBean.currentPage-i>-3}">
                        <a href="ClassesListPageServlet?currentPage=${i }">${i }</a>
                    </c:if>

                </c:forEach>


                <c:if test="${pageBean.currentPage !=pageBean.totalPage }">
                    <a href="ClassesListPageServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> |
                    <a href="ClassesListPageServlet?currentPage=${pageBean.totalPage }">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
