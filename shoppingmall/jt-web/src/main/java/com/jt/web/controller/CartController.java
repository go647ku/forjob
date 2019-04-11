package com.jt.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Cart;
import com.jt.web.pojo.User;
import com.jt.web.service.CartService;
import com.jt.web.util.UserThreadLocal;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	// 根据userId查询购物车数据
	@RequestMapping("/show.html")
	public String findCartByUserId(Model model,HttpServletRequest request) {
		
		User user = (User) request.getAttribute("JT_USER");
		
		Long userId = user.getId(); // 暂时写死，稍后维护
		
		List<Cart> cartList = cartService.findCartByUserId(userId);
		
		model.addAttribute("cartList",cartList);
		
		return "cart";
	}
	
	// 购物车新增
	@RequestMapping("/add/{itemId}")
	public String saveCart(Cart cart,HttpServletRequest request) {// 只要你用对象来接收，以后统统不用写对应属性来接收，对象会帮你用set接收
		
		User user = (User) request.getAttribute("JT_USER");
		
		Long userId = user.getId();
		
		cart.setUserId(userId);
		
		cartService.saveCart(cart);
		
		return "redirect:/cart/show.html";
		
	}
	
	// http://www.jt.com/service/cart/update/num/562379/3
	// http://cart.jt.com/cart/update/num/{userId}/{itemId}/{num}
	// 实现购物车的修改
	@RequestMapping("/update/num/{itemId}/{num}")
	public String updateCart(Cart cart,HttpServletRequest request) {
		
		User user = (User) request.getAttribute("JT_USER");
		
		Long userId = user.getId();
		
		cart.setUserId(userId);
		
		cartService.saveCart(cart);
		
		return "redirect:/cart/show.html";
		
	}
	
//	// http://www.jt.com/cart/delete/562379.html
//	@RequestMapping("/delete/{itemId}")
//	public String deleteCart(Cart cart,HttpServletRequest request) {
//		
//		User user = (User) request.getAttribute("JT_USER");
//		
//		Long userId = user.getId();
//		
//		cart.setUserId(userId);
//		
//		cartService.deleteCart(cart);
//		
//		return "redirect:/cart/show.html";
//		
//	}
	@RequestMapping("/delete/{itemId}")
	public String deleteCart(@PathVariable Long itemId,HttpServletRequest request) {
		
//		User user = (User) request.getAttribute("JT_USER");
//		
//		Long userId = user.getId();
		
		User user = UserThreadLocal.get();
		
		Long userId = user.getId();
		
		cartService.deleteCartById(userId,itemId);
		
		// 重定向到列表页面
		return "redirect:/cart/show.html";
		
	}
	
	// 模拟商品发修改
//	@RequestMapping("/update/num/{itemId}/{num}")
//	@ResponseBody
//	public SysResult updateCartNum(Cart cart) {
//		
//		System.out.println("当前商品修改成功");
//		
//		return SysResult.oK();
//	}
	
	
}
