package servlet;

import bean.Student;
import dao.StuDao;
import imp.StuImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Search",urlPatterns = "/Search")
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        // 获取用户输入的值
        String search = request.getParameter("search");
        String searchBy = request.getParameter("find");
        // 创建工具类对象
        StuDao stuDao = new StuImp();
        ArrayList<Student> arrayList = new ArrayList<>();
        if (search == null || search.equals("")) {
            arrayList = stuDao.getAll();
        } else {
            switch (searchBy) {
                case "学号":
                    arrayList = stuDao.getLikesById(Integer.parseInt(search));
                    break;
                case "姓名":
                    arrayList = stuDao.getLikesByName(search);
                    break;
                case "年龄":
                    arrayList = stuDao.getLikesByAge(Integer.parseInt(search));
                    break;
                case "专业":
                    arrayList = stuDao.getLikesByMajor(search);
                    break;
            }
        }
        request.getSession().setAttribute("allStudents",arrayList);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
