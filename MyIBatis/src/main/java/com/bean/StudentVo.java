package com.bean;

import java.io.Serializable;

// 定义一个包装类型
public class StudentVo implements Serializable {
    private Student student;
    private String name;

    @Override
    public String toString() {
        return "StudentVo{" +
                "student=" + student +
                ", name='" + name + '\'' +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
