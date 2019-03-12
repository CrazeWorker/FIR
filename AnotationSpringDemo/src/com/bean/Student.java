package com.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private int number;
    private String img;
    private String name;
    private int age;
    private String major;

    public Student() {
    }

    @Override
    public String toString() {
        return "Studente{" +
                "number=" + number +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void updateStudent(Student student) {
    }
}
