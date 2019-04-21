package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    // 分页查询商品
    EasyUIDataGridResult getItemList(int total,int rows);
    // 新增商品信息
    TaotaoResult saveItem(TbItem item, String desc);
}
