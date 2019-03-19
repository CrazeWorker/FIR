package dao.imp;

import bean.Student;
import dao.StudentDao;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements StudentDao {

    private DBUtil db;
    public void setDb(DBUtil db) {
        this.db = db;
    }
    @Override
    public List<Student> findAllStudent() {
        List<Student> arr = new ArrayList<>();
        String sql = "select * from student";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Student student = new Student(rs.getInt("number"), rs.getString("img"), rs.getString("name"), rs.getInt("age"), rs.getString("major"));
                arr.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public Student findStudent(int number) {
        String sql = "select * from student where number = "+number;
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Student student = new Student(rs.getInt("number"), rs.getString("img"), rs.getString("name"), rs.getInt("age"), rs.getString("major"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
