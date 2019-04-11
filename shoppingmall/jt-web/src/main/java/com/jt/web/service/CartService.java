package com.jt.web.service;

import java.util.List;

import com.jt.web.pojo.Cart;

public interface CartService {

	List<Cart> findCartByUserId(Long userId);

	void saveCart(Cart cart);

	// void deleteCart(Cart cart);

	void deleteCartById(Long userId, Long itemId);

}
