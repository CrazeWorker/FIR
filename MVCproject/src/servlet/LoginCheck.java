package servlet;

import bean.Student;
import dao.StuDao;
import dao.UserDao;
import imp.StuImp;
import imp.UserImp;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LoginCheck",urlPatterns = "/LoginCheck")
public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        // 获取用户输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 创建用户操作类
        UserDao userDao = new UserImp();
        // 创建session
        HttpSession session = request.getSession();
        // 将username保存到session中
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        if (userDao.login(username, password)) {
            // 查询学生信息放入Session
            StuDao stuDao = new StuImp();
            ArrayList<Student> all = stuDao.getAll();
            session.setAttribute("allStudents",all);
            request.getRequestDispatcher("show.jsp").forward(request,response);
        } else {
            JOptionPane.showMessageDialog(null,"用户名或密码错误!请重新输入!");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
