package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.Item;

//定义Mapper接口
public interface ItemMapper extends SysMapper<Item>{
	/**
	 * 如果操作数据库的sql比较简单，可以通过注解的形式进行编辑
	 * 
	 * @return
	 */
	

	int findItemCount();

	
	/**
	 * 
	 * Mybatis中传值要求，不允许多值传参，如果需要多值传参，将多值转化为单值
	 * 1、使用的对象进行封装，insert update
	 * 2、使用集合封装，list array map
	 * @param start
	 * @param rows
	 * @return
	 */
	
	List<Item> findItemListByPage(@Param("start") int start,@Param("rows") int rows);

	
	
	@Select ("select name from  tb_item_cat where id=#{itemCatId}") 
	String findItemCatNameById(Long itemCatId);


	void saveItem(Item item);


	void updateStatus(@Param("ids") Long[] ids, @Param("status") int status);


	void deleteOne(@Param("id") Long[] id);


	


	
	
}
