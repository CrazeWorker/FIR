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

@WebServlet(name = "Delete",urlPatterns = "/Delete")
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 创建工具类
        StuDao stuDao = new StuImp();
        if (stuDao.deleteStudent(Integer.parseInt(request.getParameter("id")))) {
            ArrayList<Student> all = stuDao.getAll();
            request.getSession().setAttribute("allStudents", all);
            JOptionPane.showMessageDialog(null, "删除成功！");
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "删除失败！");
            request.getRequestDispatcher("show.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
