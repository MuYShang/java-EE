package com.hwl.springmvc.controller;


import com.hwl.springmvc.pojo.Items;
import com.hwl.springmvc.pojo.QueryVo;
import com.hwl.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    // @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
    // action可以写也可以不写
    @RequestMapping("/itemList")
    public ModelAndView queryList(){
      List<Items> list = this.itemService.selectItemsList();
        //创建ModelAndView用来存放数据和视图
        ModelAndView modelAndView = new ModelAndView();
        //设置数据到模型中
        modelAndView.addObject("list",list);
        //modelAndView.setViewName("/jsp/itemList.jsp");
        modelAndView.setViewName("itemList");
        return  modelAndView;
    }

    //根据id查询
    @RequestMapping("itemListById")
    public ModelAndView queryItemById(HttpServletRequest request){
        String strId = request.getParameter("id");
        Integer id = Integer.parseInt(strId);
        Items items = this.itemService.selectItemsById(id);
        ModelAndView modelAndView = new ModelAndView();
        //设置数据到模型中
        modelAndView.addObject("items",items);
        //modelAndView.setViewName("/jsp/itemList.jsp");
        modelAndView.setViewName("itemList");
        return  modelAndView;
    }

    @RequestMapping("queryItem")
    public String queryItem(QueryVo queryVo,Integer [] ids){
        System.out.println(queryVo.getItems().getId());
        System.out.println(queryVo.getItems().getName());
        System.out.println(queryVo.getIds().length);
        System.out.println(ids.length);
        return "success";
    }
}
