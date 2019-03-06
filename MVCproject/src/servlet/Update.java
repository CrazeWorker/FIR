package servlet;

import bean.Student;
import dao.StuDao;
import imp.StuImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Update",urlPatterns = "/Update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        // 获取用户输入信息
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String major = request.getParameter("major");
        int age = Integer.parseInt(request.getParameter("age"));
        // 封装对象
        Student student = new Student();
        student.setImg(img);
        student.setMajor(major);
        student.setAge(age);
        student.setSname(name);
        student.setSid(id);
        // 创建工具类
        StuDao stuDao = new StuImp();
        // 更新
        if (stuDao.updateStudent(student)) {
            ArrayList<Student> all = stuDao.getAll();
            request.getSession().setAttribute("allStudents", all);
            JOptionPane.showMessageDialog(null, "修改成功！");
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "修改失败！");
            request.getRequestDispatcher("updateStu.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
