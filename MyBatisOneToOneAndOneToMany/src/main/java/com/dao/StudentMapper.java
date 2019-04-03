package com.dao;

import com.bean.Student;

import java.util.List;

public interface StudentMapper {

    // 同时打印student的订单信息，一对多
    List<Student> selectAll();
}
