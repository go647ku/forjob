package com.jt.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.annotation.CacheAnno;
import com.jt.common.annotation.CacheAnno.CACHE_TYPE;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;
import com.jt.manage.vo.EasyUITree;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;



	public List<ItemCat> findItemCatByParentId(long parentId) {
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);
		return itemCatMapper.select(itemCat);

	}

	
	@Override
	@CacheAnno(key="ITEM_CAT",index=0,targetClass=ArrayList.class,cacheType=CACHE_TYPE.FIND)
	public List<EasyUITree> findItemCatList(long parentId) {
		List<EasyUITree> treeList = new ArrayList<>();
		List<ItemCat> itemCatList = findItemCatByParentId(parentId);
		ObjectMapper objectMapper = new ObjectMapper();

		for (ItemCat itemCat : itemCatList) {
			EasyUITree easyUITree = new EasyUITree();
			easyUITree.setId(itemCat.getId());
			easyUITree.setText(itemCat.getName());
			// 一二级使用close，三级使用open
			String state = itemCat.getIsParent() ? "closed" : "open";

			easyUITree.setState(state);

			treeList.add(easyUITree);
			System.out.println(treeList);
		}
		return treeList;
	}

	/**
	 * 1.生成key 2.查询redis缓存 null:则调用业务层方法会哦去数据,利用工具封装为json,保存到缓存 不为null:将缓存转化为对象返回
	 * 改代码耦合性高: AOP:采用AOP形式实现redis缓存操作
	 */


//
//	@Override 
//	public List<EasyUITree> findCacheItemCat(Long parentId) {
//		String key="ITEM_CAT"+parentId;
//		String json = redisService.get(key); 
//		List<EasyUITree> EasyUITree=new ArrayList(); 
//		if(StringUtils.isEmpty(json)) { 
//			EasyUITree =findItemCatList(parentId); 
//			String json2 =ObjectMapperUtil.toJson(EasyUITree); 
//			redisService.set(key, json2);
//			return EasyUITree; }
//		else {
//			List<EasyUITree> object = ObjectMapperUtil.toObject(json,EasyUITree.getClass()); 
//			return object; }
//	
//	}
//	

}

