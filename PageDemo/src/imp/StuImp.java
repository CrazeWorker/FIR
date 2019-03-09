package imp;

import bean.Student;
import dao.StuDao;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuImp implements StuDao {
    public static final int PAGE_NUM = 4;
    @Override
    public int getPageCount() {
        int count = 0;
        DBUtil db = DBUtil.getDBUtil();
        ResultSet resultSet = db.executeQuery("select count(number) from student");
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return (int)Math.ceil((double) (count / PAGE_NUM));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Student> getStudent(int thisPage) {
        ArrayList<Student> arr = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student limit "+(thisPage-1)*PAGE_NUM+","+PAGE_NUM;
        ResultSet resultSet = db.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Student student = new Student();
                student.setSid(resultSet.getInt("number"));
                student.setAge(resultSet.getInt("age"));
                student.setSname(resultSet.getString("name"));
                student.setImg(resultSet.getString("img"));
                student.setMajor(resultSet.getString("major"));
                arr.add(student);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
