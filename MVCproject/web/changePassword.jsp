<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="changePassword" method="post">
    <%
        String username = (String) request.getSession().getAttribute("username");
    %>
    <table align="center">
        <tr align="center">
            <th style="font-size: 30px" colspan="2">
                <img src="img/皇冠.png" style="width: 200px;height: 50px"><br>修改密码<br>
                <img src="img/皇冠2.png" style="width: 200px;height: 20px"></th>
        </tr>
        <tr>
            <td class="f1">用户名：</td>
            <td><input type="text" readonly="readonly" name="username" value=<%=username%>></td>
        </tr>
        <tr>
            <td class="f1">旧密码：</td>
            <td><input type="password"  name="password"></td>
        </tr>
        <tr>
            <td class="f1">新密码：</td>
            <td><input type="password"  name="newpassword"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" name="submit" value="提交"></td>
        </tr>
        </tr>
    </table>
</form>
</body>
</html>
