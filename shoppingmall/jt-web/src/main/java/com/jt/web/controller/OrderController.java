package com.jt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Cart;
import com.jt.web.pojo.Order;
import com.jt.web.service.CartService;
import com.jt.web.service.OrderService;
import com.jt.web.util.UserThreadLocal;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	// http://www.jt.com/order/create.html
//	@RequestMapping("/create.html")
//	public void create(HttpServletResponse response) throws IOException {
//		response.setHeader("Content-type", "text/html;charset=UTF-8");
//		PrintWriter writer = response.getWriter();
//		writer.print("恭喜李哥购买成功，打钱！！");
//		// 设置名为Refresh的响应头【Refresh 也是会在地址栏里有变化】
//		response.setHeader("Refresh", "5;URL=http://www.jt.com/cart/show.html"); 
//		// 5表示时间，URL=项目名+Servlet的url-pattern
//		
//	}
	// 实现订单页面跳转
	@RequestMapping("/create")
	public String create(Model model) {
		
		long userId = UserThreadLocal.get().getId();
		
		List<Cart> cartList = cartService.findCartByUserId(userId);
		
		model.addAttribute("carts", cartList);
		
		// 跳转订单确认 转发操作
		return "order-cart";
		
	}
	
	/**	3张表关联 分组 条件 封装 关联 左外...200-300行
	 *  sql:insert into user(字段)values(#{})
	 *  	insert into userB..........;
	 *  	insert into xxx(......)values(......)
	 */
	
	// 实现订单新增 jt-web jt-order是不是同一个线程 铁定不是
	@RequestMapping("/submit")
	@ResponseBody
	public SysResult saveOrder(Order order) {
		
		Long userId = UserThreadLocal.get().getId();
		
		order.setUserId(userId);
		
		String orderId = orderService.saveOrder(order);
		
		if(!StringUtils.isEmpty(orderId)) 
		
			return SysResult.oK(orderId);
		
		 else 
			 
			return SysResult.build(201, "订单新增失败");
		
	}
	
	// 实现订单查询
	@RequestMapping("/success")
	public String findOrderById(String id,Model model) {
		
		//根据orderId获取订单信息
		Order order = orderService.findOrderById(id);
		
		model.addAttribute("order",order);
		
		// 要携带参数肯定就是转发
		return "success";
		
	}
	
}
