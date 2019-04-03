package com.bean;

public class StudentAccount extends Account {
    private String stu_name;
    private String stu_major;

    @Override
    public String toString() {
        return super.toString()+","+"StudentAccount{" +
                "stu_name='" + stu_name + '\'' +
                ", stu_major='" + stu_major + '\'' +
                '}';
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_major() {
        return stu_major;
    }

    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
    }
}
