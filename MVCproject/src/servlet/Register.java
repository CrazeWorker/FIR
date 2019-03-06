package servlet;

import dao.UserDao;
import imp.UserImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "Register",urlPatterns = "/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        // 获取文本框的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repass = request.getParameter("repass");
        String nickname = request.getParameter("nickname");
        // 创建用户对象
        UserDao userDao = new UserImp();
        if (userDao.getUserName(username)) {
            if (userDao.isSame(password, repass)) {
                userDao.addUser(username, password, nickname);
                JOptionPane.showMessageDialog(null, "注册成功！");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } else {
                JOptionPane.showMessageDialog(null, "两次输入不一致！请重新输入！");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } else {
            JOptionPane.showMessageDialog(null, "该用户名已被占用！");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
