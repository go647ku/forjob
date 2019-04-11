package com.jt.cart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.cart.mapper.CartMapper;
import com.jt.cart.pojo.Cart;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Cart> findCartByUserId(Long userId) {

		QueryWrapper queryWrapper = new QueryWrapper();
		
		queryWrapper.eq("user_id", userId);
			
		return cartMapper.selectList(queryWrapper);
	}
	
	/**
	 * 1.根据userId和itemId查询购物车
	 * 2.判断购物车是否有该数据
	 * 3.如果有数据
	 * 		只做修改数量的操作
	 * 	如果没有数据
	 * 		则新增操作
	 */
	@Transactional
	@Override
	public void saveCart(Cart cart) {
		
		QueryWrapper queryWrapper = new QueryWrapper();
		
		queryWrapper.eq("user_id", cart.getUserId());
		
		Cart cartDB = cartMapper.selectOne(queryWrapper);
		
		if(cartDB == null) {
			
			// 做新增操作
			cart.setCreated(new Date());
			
			cart.setUpdated(cart.getCreated());
			
			cartMapper.insert(cart);
			
		} else {
			
			// 数量的修改操作
			int num = cartDB.getNum() + cart.getNum();
			
			cartDB.setNum(num);
			
			cartDB.setUpdated(new Date());
						
			cartMapper.doUpdateById(cartDB.getId(),cart.getNum());
			
		}
		
	}

//	@Override
//	public void deleteCart(Cart cart) {
//		
//		cartMapper.deleteCart(cart.getUserId(),cart.getItemId());
//		
//	}

	@Override
	public void deleteCartById(Cart cart) {
		
		QueryWrapper<Cart> queryWrapper = new QueryWrapper(cart);
		
		cartMapper.delete(queryWrapper);
		
		System.out.print("删除成功！！");
		
	}
	
}
