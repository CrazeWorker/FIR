package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.IDUtils;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    // 注入mapper
    @Autowired
    TbItemMapper itemMapper;
    @Autowired
    TbItemDescMapper itemDescMapper;
    @Override
    public EasyUIDataGridResult getItemList(int total, int rows) {
        // 分页查询
        PageHelper.startPage(total, rows);
        // 创建Example
        TbItemExample example = new TbItemExample();
        // 查询数据
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        // 获取查询结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        // 创建EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        // 封装结果
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(tbItems);
        // 返回
        return result;
    }

    @Override
    public TaotaoResult saveItem(TbItem item, String desc) {
        // 1、生成商品ID
        long itemId = IDUtils.genItemId();
        // 2、补全商品信息
        item.setId(itemId);
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 3、向表中插入数据
        itemMapper.insert(item);
        // 4、创建一个Desc对象,并补全信息
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        itemDescMapper.insert(tbItemDesc);
        return TaotaoResult.ok();
    }
}
