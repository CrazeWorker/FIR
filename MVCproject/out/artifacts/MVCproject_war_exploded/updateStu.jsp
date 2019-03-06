<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".imgInput").change(function(){
            $(".img").attr("src",URL.createObjectURL($(this)[0].files[0]));
        });
    });
</script>
<form action="Update" method="post">
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String major = request.getParameter("major");
        String img = "img\\星纹社.jpg";
    %>
    <fieldset style="width: 400px;margin: 0px auto">
        <legend>更改学生信息</legend>
        <table align="center">
            <tr>
                <td align="right">学号：</td><td><input type="text" name="id" readonly="readonly" value=<%=id%>></td>
            </tr>
            <tr><td align="right">姓名：</td><td><input type="text" name="name" value=<%=name%>></td></tr>
            <tr><td align="right">证件照：</td><td><input type="file" name="img" class="imgInput" value=<%=img%>></td></tr>
            <tr><td align="right">年龄：</td><td><input type="text" name="age" value=<%=age%>></td></tr>
            <tr>
                <td></td><td><img src="img/星纹社.jpg" width="80px" height="80px" class="img"></td>
            </tr>
            <tr>
                <td align="right">专业：</td>
                <td>
                    <select name="major">
                        <option selected><%=major%></option>
                        <option>厨师</option>
                        <option>汽修电焊</option>
                        <option>美容美发</option>
                        <option>挖掘机</option>
                        <option>网路工程</option>
                        <option>计算机</option>
                        <option>数字媒体</option>
                        <option>艺术工程</option>
                        <option>软件工程</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td><td><input type="submit" name="submit" value="确认修改"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
