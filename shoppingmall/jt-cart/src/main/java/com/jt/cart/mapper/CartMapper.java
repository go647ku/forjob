package com.jt.cart.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.cart.pojo.Cart;

public interface CartMapper extends BaseMapper<Cart>{

	void doUpdateById(@Param("id")Long id,@Param("num") Integer num);

	void deleteCart(@Param("userId")Long userId, @Param("itemId")Long itemId);

}
