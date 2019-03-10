package com.bean;

import java.util.List;
import java.util.Properties;

public class TeacherBean {
    private StudentBean studentBean;
    private List list;
    private Properties properties;

    @Override
    public String toString() {
        return "TeacherBean{" +
                "studentBean=" + studentBean +
                ", list=" + list +
                ", properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public TeacherBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public TeacherBean() {
    }
}
