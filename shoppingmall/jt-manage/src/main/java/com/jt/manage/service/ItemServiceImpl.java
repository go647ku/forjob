package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.vo.EasyUITable;
import com.jt.manage.pojo.Item;
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private ItemDescMapper itemDescMapper;
	
	
	
	@Override
	public EasyUITable findItemListByPage(int page, int rows) {
		EasyUITable table=new EasyUITable();
		
		//int total=itemMapper.findItemCount();
		
		int total=itemMapper.selectCount(null);//如果查询时不需要添加where条件，就写null
		int start=(page-1)*rows;
		//分页以后的记录
		List<Item> itemList=itemMapper.findItemListByPage(start,rows);
		table.setTotal(total);
		table.setRows(itemList);
		return table;
	}



	@Override
	public String findItemCatNameById(Long itemCatId) {
		return  itemMapper.findItemCatNameById(itemCatId);
		
		
	}



	@Override
	public void saveItem(Item item,String desc) {
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		int a=itemMapper.insert(item);
		
		//动态回显新增ID
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getUpdated());
		int insert = itemDescMapper.insert(itemDesc);
		System.out.println("insert="+insert);
		
	}



	@Override
	public void updateStatus(Long[] ids, int status) {
		itemMapper.updateStatus(ids,status);
	}



	@Override
	public void updateItem(Item item,String desc) {
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
	
		//动态回显新增ID
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getUpdated());
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
		
	}



	@Override
	public void delete(Long[] ids) {
	
	System.out.println(ids.length);
		itemMapper.deleteByIDS(ids);
		
	
	}



	@Override
	public ItemDesc findItemDescById(Long itemId) {
		ItemDesc selectByPrimaryKey = itemDescMapper.selectByPrimaryKey(itemId);
		
		return selectByPrimaryKey;
	}


//根据id获取item对象
	@Override
	public Item findItemById(Long itemId) {
		// TODO Auto-generated method stub
		return itemMapper.selectByPrimaryKey(itemId);
	}




	
	
}
