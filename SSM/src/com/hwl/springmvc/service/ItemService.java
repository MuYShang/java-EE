package com.hwl.springmvc.service;

import java.util.List;

import com.hwl.springmvc.pojo.Items;

public interface ItemService {
	//查询所有商品
	public List<Items> selectItemsList();
	//根据id查询
	public Items selectItemsById(Integer id);

	//修改
	public void updateItemsById(Items items);

	//删除,根据id
	public void deleteItems(Integer id);

	//添加
	public void addItems(Items items);
}
