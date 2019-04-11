package com.jt.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.jt.order.pojo.Order;
import com.jt.order.service.OrderService;
import com.jt.order.util.ObjectMapperUtil;
import com.jt.order.vo.SysResult;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/create")
	public SysResult saveOrder(String orderJSON) {
		
		Order order = ObjectMapperUtil.toObject(orderJSON, Order.class);
		
		// 传递数据时最好把他以对象的形式封装
		String orderId = orderService.saveOrder(order);
		
		if(!StringUtils.isEmpty(orderId)) {
			
			return SysResult.oK(orderId);
			
		} else {
			
			return SysResult.build(201,"新增订单失败");
			
		}
		
	}
	
	// 根据orderId查询order信息
	@RequestMapping("/query/{orderId}")
	public Order findOrderById(@PathVariable String orderId) {
		
		return orderService.findOrderById(orderId);
		
	}
}
