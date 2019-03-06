package servlet;

import bean.Student;
import dao.StuDao;
import dao.UserDao;
import imp.StuImp;
import imp.UserImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "ChangePassword",urlPatterns = "/changePassword")
public class ChangePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        // 获取表单中的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        // 创建工具类
        UserDao userDao = new UserImp();
        if (userDao.changePassword(password, newpassword, username)) {
            JOptionPane.showMessageDialog(null, "修改密码成功！");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "修改密码失败！");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
