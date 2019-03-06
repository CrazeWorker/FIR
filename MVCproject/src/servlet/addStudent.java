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

@WebServlet(name = "addStudent",urlPatterns = "/addStudent")
public class addStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        // 获取表单中的值
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String major = request.getParameter("major");
        int age = Integer.parseInt(request.getParameter("age"));
        // 创建学生对象并且给各个属性赋值
        Student student = new Student();
        student.setSname(name);
        student.setImg("img\\星纹社.jpg");
        student.setSid(id);
        student.setMajor(major);
        student.setAge(age);
        // 创建学生工具类，添加学生信息
        StuDao stuDao = new StuImp();
            if (stuDao.addStudent(student)) {
                JOptionPane.showMessageDialog(null, "添加成功！");
                // 重新查询学生信息
                StuDao stuDao1 = new StuImp();
                ArrayList<Student> all = stuDao1.getAll();
                request.getSession().setAttribute("allStudents", all);
                request.getRequestDispatcher("show.jsp").forward(request, response);
            } else {
                JOptionPane.showMessageDialog(null, "添加失败！请重试！");
                request.getRequestDispatcher("addStu").forward(request, response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
