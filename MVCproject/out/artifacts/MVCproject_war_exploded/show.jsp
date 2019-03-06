<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <%
        String username = (String) request.getSession().getAttribute("username");
        String password = (String) request.getSession().getAttribute("password");
    %>
    欢迎<c:out value="${username}"/>来到学生管理系统!<a href="changePassword.jsp">修改密码</a>&nbsp;&nbsp;<a href="index.jsp">注销</a>
</div>
<form action="Search">
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

        <%--<%--%>
            <%--HttpSession session1 = request.getSession();--%>
            <%--ArrayList<Student> students = (ArrayList<Student>) session1.getAttribute("allStudents");--%>
            <%--for (Student stu : students) {--%>
        <%--%>--%>
        <c:forEach items="${allStudents}" var="stu">
        <tr align="center">
            <td width="80px"><img src=<c:out value="${stu.img}"/> width="80px" height="80px"></td>
            <td><c:out value="${stu.sid}"/>
            </td>
            <td><c:out value="${stu.sname}"/>
            </td>
            <td><c:out value="${stu.age}"/>
            </td>
            <td><c:out value="${stu.major}"/>
            </td>
            <td>
                <a href="updateStu.jsp?id=${stu.sid}&name=${stu.sname}&age=${stu.age}&major=${stu.major}">
                    <input type="button" name="btn1" value="修改" style="margin-right: 20px"></a>
                    <a href="Delete?id=${stu.sid}"> <input type="button" name="btn2" value="删除"></a></td>
        </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
