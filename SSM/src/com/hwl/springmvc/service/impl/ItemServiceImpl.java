package com.hwl.springmvc.service.impl;

import java.util.Date;
import java.util.List;

import com.hwl.springmvc.mapper.ItemsMapper;
import com.hwl.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwl.springmvc.pojo.Items;


@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;

	//查询商品列表
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExample(null);
	}
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}


	//修改
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	//根据id删除
	@Override
	public void deleteItems(Integer id) {
		itemsMapper.deleteByPrimaryKey(id);
	}
	//添加
	@Override
	public void addItems(Items items) {
		itemsMapper.insertSelective(items);
	}
}
