package Servelet;

import bean.Student;
import dao.StuDao;
import imp.StuImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet",urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inPage = request.getParameter("inPage");
        StuDao stuDao = new StuImp();
        ArrayList<Student> student = stuDao.getStudent(Integer.parseInt(inPage));
        HttpSession session = request.getSession();
        session.setAttribute("allStudents", student);
        session.setAttribute("pageNow", Integer.parseInt(inPage));
        session.setAttribute("number",stuDao.getPageCount());
        request.getRequestDispatcher("success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int pageNow = 1;
        String thisPage = request.getParameter("thisPage");
        if (thisPage != null) {
            pageNow = Integer.parseInt(thisPage);
        }

        //
        StuDao stuDao = new StuImp();
        ArrayList<Student> student = stuDao.getStudent(pageNow);
        HttpSession session = request.getSession();
        session.setAttribute("allStudents", student);
        session.setAttribute("pageNow", pageNow);
        session.setAttribute("number",stuDao.getPageCount());
        request.getRequestDispatcher("success.jsp").forward(request,response);
    }
}
