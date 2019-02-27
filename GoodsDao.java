package dao;

import bean.Goods;

import java.util.ArrayList;

public interface GoodsDao {
    ArrayList<Goods> getByValue(String value);
}
