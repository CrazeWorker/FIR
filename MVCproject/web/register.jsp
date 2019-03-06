<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="margin-top: 200px" action="register" method="post">
    <table align="center">
        <tr align="center">
            <th style="font-size: 30px" colspan="2">
                <img src="img/皇冠.png" style="width: 200px;height: 50px"><br>注册<br>
                <img src="img/皇冠2.png" style="width: 200px;height: 20px"></th>
        </tr>
        <tr>
            <td class="f1">用户名：</td>
            <td><input type="text" name="username" class="c1"></td>
        </tr>
        <tr>
            <td class="f1">昵称：</td>
            <td><input type="text" name="nickname" class="c1"></td>
        </tr>
        <tr>
            <td class="f1">密&nbsp;&nbsp;码：</td>
            <td><input type="password"  name="password" class="c1"></td>
        </tr>
        <tr>
            <td class="f1">确认密码：</td>
            <td><input type="password"  name="repass" class="c1"></td>
        </tr>
        <tr>
            <td><input type="reset" name="reset" value="重置" class="b1"></td>
            <td align="right"><input type="submit" name="submit" value="提交" class="b1"></td>
        </tr>
        </tr>
    </table>
</form>
</body>
</html>
