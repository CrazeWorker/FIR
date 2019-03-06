<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="LoginCheck" method="post">
    <table align="center">
        <tr>
            <th style="font-size: 30px" colspan="2">登陆系统</th>
        </tr>
        <tr>
            <td class="f1">用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td class="f1">密&nbsp;码：</td>
            <td><input type="password"  name="password""></td>
        </tr>
        <tr>
            <td><a href="register.jsp"><input type="button" name="register" value="注册"></a></td>
            <td align="right"><input type="submit" name="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
