<%@ page import="dao.StuDao" %>
<%@ page import="imp.StuImp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-image: url(img/背景图片素材.png);">
<div align="right">
</div>
    <table width="800px" align="center" border="1px" cellspacing="0px">
        <caption><h1>学生信息表</h1></caption>
        <tr>
            <td colspan="6" align="right"><a href="addStu.jsp"><input type="button" name="add" value="添加学生"></a></td>
        </tr>
        <tr>
            <td colspan="6" align="right">
                <select name="find">
                    <option SELECTED>学号</option>
                    <option>姓名</option>
                    <option>年龄</option>
                    <option>专业</option>
                </select>
                <input type="text" name="search" placeholder="请输入要搜索的学生信息">
                <a href="Search"><input type="submit" name="btn" value="搜索"></a>
            </td>
        </tr>
        <tr align="center">
            <th>证件照</th>
            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>专业</th>
            <th style="width: 150px">操作</th>
        </tr>
        <c:forEach items="${allStudents}" var="stu">
        <tr align="center">
            <td width="80px"><img src="${stu.img}" width="80px" height="80px"></td>
            <td>${stu.sid}
            </td>
            <td>${stu.sname}
            </td>
            <td>${stu.age}
            </td>
            <td>${stu.major}
            </td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="6"><a href="Servlet?thisPage=1">首页</a>
                <a href="Servlet?thisPage=${pageNow-1}">上一页</a>
                <form action="Servlet" method="post">
                    <script>
                        function change() {
                            var inpage = document.getElementById("inPage").value;
                            var href = "Servlet?thisPage=" + Number(inpage);
                            var a = document.getElementById("jump");
                            a.setAttribute("href", href);
                        }
                    </script>
                    <select name="inPage" id="inPage">
                        <%
                            StuDao stuDao = new StuImp();
                            for (int i = 1;i<= stuDao.getPageCount();i++) {
                        %>
                        <option value="<%=i%>"><%=i%></option>
                        <%
                            }
                        %>
                    </select>
                    <a href="" id="jump" onclick="change()">跳转</a>

                    <%--<input type="submit" value="跳转">--%>
                <a href="Servlet?thisPage=${pageNow+1}">下一页</a>
                <a href="Servlet?thisPage=${number}">尾页</a></td>
        </tr>
    </table>
</form>
</body>
</html>
