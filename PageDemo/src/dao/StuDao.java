package dao;

import bean.Student;

import java.util.ArrayList;

public interface StuDao {
    // 返回页数
    public int getPageCount();

    //
    public ArrayList<Student> getStudent(int thisPage);
}
