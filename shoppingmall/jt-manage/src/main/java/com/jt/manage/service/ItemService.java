package com.jt.manage.service;

import java.util.List;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.vo.EasyUITable;
import com.jt.manage.pojo.Item;

public interface ItemService {

	EasyUITable findItemListByPage(int page, int rows);

	String findItemCatNameById(Long itemCatId);

	void saveItem(Item item,String desc);

	void updateStatus(Long[] ids, int status);

	void updateItem(Item item,String desc);

	void delete(Long[] ids);

	ItemDesc findItemDescById(Long itemId);

	Item findItemById(Long itemId);
}
