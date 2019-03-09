<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="util.DBUtil" %>
<%@ page import="dao.StuDao" %>
<%@ page import="imp.StuImp" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
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
    int pageNum = 4;
    String pageCount1 = request.getParameter("pageCount");
    if (pageCount1 == null || pageCount1.equals("")) {
      pageCount1 = "1";
    }
    int pageCount = Integer.parseInt(pageCount1);
    DBUtil db = DBUtil.getDBUtil();
    ResultSet rs = db.executeQuery("select * from student");
    rs.last();
    int number = rs.getRow()/pageNum;
  %>
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

    <%
      if (pageCount == 1) {
        rs.beforeFirst();
      } else {
        rs.absolute((pageCount-1)*pageNum);
      }
    int count = 1;
      try {
        while (rs.next()) {
    %>
    <tr align="center">
      <td width="80px"><img src=<%=rs.getString("img")%> width="80px" height="80px"></td>
      <td><%=rs.getInt("number")%>
      </td>
      <td><%=rs.getString("name")%>
      </td>
      <td><%=rs.getString("age")%>
      </td>
      <td><%=rs.getString("major")%>
      </td>
    </tr>
    <%
          if (count == 4) {
            count = 1;
            break;
          }
          count++;
        }
      } catch (SQLException e) {
          e.printStackTrace();
      }
    %>
    <tr>
      <td colspan="6"><a href="index.jsp?pageCount=1">首页</a><a href=<%="index.jsp?pageCount="+(pageCount-1)%>>上一页</a><a href=<%="index.jsp?pageCount="+(pageCount+1)%>>下一页</a><a href=<%="success.jsp?thisPage="+number%>>尾页</a></td>
    </tr>
  </table>
</form>

<hr/>
<a href="Servlet?thisPage=1">Go</a>
</body>
</html>
