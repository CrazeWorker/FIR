package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    // 注入服务
    @Autowired
    private ItemService itemService;
    /**
     * 分页查询数据，请求方式为get
     * @param page 第几页
     * @param rows 几行
     * @return
     */
    @RequestMapping(path = "/item/list",method =  RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(int page, int rows) {
        // dubbo引入服务
        return itemService.getItemList(page, rows);
    }

    @RequestMapping(path = "/item/save")
    @ResponseBody
    public TaotaoResult saveItem(TbItem tbItem, String desc) {
        return itemService.saveItem(tbItem, desc);
    }

}
