package imp;

import bean.Student;
import dao.StuDao;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuImp implements StuDao {
    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> arr = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Student stu = new Student();
                stu.setAge(rs.getInt("age"));
                stu.setMajor(rs.getString("major"));
                stu.setSid(rs.getInt("number"));
                stu.setSname(rs.getString("name"));
                stu.setImg(rs.getString("img"));
                arr.add(stu);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getLikesById(int id) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student where number like '%" + id + "%'";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Student> arr = new ArrayList<>();
        try {
            while (rs.next()) {
                Student stu = new Student();
                stu.setAge(rs.getInt("age"));
                stu.setMajor(rs.getString("major"));
                stu.setSid(rs.getInt("number"));
                stu.setSname(rs.getString("name"));
                stu.setImg(rs.getString("img"));
                arr.add(stu);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getLikesByName(String name) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student where name like '%" + name + "%'";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Student> arr = new ArrayList<>();
        try {
            while (rs.next()) {
                Student stu = new Student();
                stu.setAge(rs.getInt("age"));
                stu.setMajor(rs.getString("major"));
                stu.setSid(rs.getInt("number"));
                stu.setSname(rs.getString("name"));
                stu.setImg(rs.getString("img"));
                arr.add(stu);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getLikesByAge(int age) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student where age like '%" + age + "%'";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Student> arr = new ArrayList<>();
        try {
            while (rs.next()) {
                Student stu = new Student();
                stu.setAge(rs.getInt("age"));
                stu.setMajor(rs.getString("major"));
                stu.setSid(rs.getInt("number"));
                stu.setSname(rs.getString("name"));
                stu.setImg(rs.getString("img"));
                arr.add(stu);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getLikesByMajor(String major) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student where major like '%" + major + "%'";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Student> arr = new ArrayList<>();
        try {
            while (rs.next()) {
                Student stu = new Student();
                stu.setAge(rs.getInt("age"));
                stu.setMajor(rs.getString("major"));
                stu.setSid(rs.getInt("number"));
                stu.setSname(rs.getString("name"));
                stu.setImg(rs.getString("img"));
                arr.add(stu);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "insert into student values(?,?,?,?,?);";
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setInt(1,student.getSid());
            ps.setString(2,student.getImg());
            ps.setString(3, student.getSname());
            ps.setInt(4,student.getAge());
            ps.setString(5,student.getMajor());
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean updateStudent(Student student) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "Update student set name='"+student.getSname()+"',age="+student.getAge()+",major='"+student.getMajor()+"' where number="+student.getSid();
        if (db.executeUpdate(sql) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "delete from student where number = " + id;
        if (db.executeUpdate(sql)>0) {
            return true;
        }
        return false;
    }

    @Override
    public Student getStudentById(int id) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from student where number = " + id;
        ResultSet rs = db.executeQuery(sql);
        Student student = new Student();
        try {
            while (rs.next()) {
                student.setSid(id);
                student.setSname(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setMajor(rs.getString("major"));
                student.setImg(rs.getString("img"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
