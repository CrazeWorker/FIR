package com.dao;

import com.bean.Carts;
import com.bean.Goods;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CartDao {
    // 删除
    boolean delete(int id);

    // 修改
    boolean update(int id, int num);

    // 插入
    boolean insert(Carts carts);

    // 获取所有
    ArrayList<Carts> getAll();

    // 根据名字查
    ArrayList<Carts> getByName(String name);

}
