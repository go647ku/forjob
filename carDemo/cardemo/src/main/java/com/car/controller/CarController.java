package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.pojo.Car;
import com.car.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	/**
	 * 登记汽车业务
	 * 根据传过来的汽车信息和用户信息
	 * 对汽车表进行插入
	 */
	@RequestMapping("/carRegister/{carId}")
	public String carRegister(@PathVariable String carId) {
		
		carService.carRegister(carId);
		
		return "汽车登记成功";
		
	}
	
	// 模拟查询用户的汽车
	@RequestMapping("/findAllCar/{id}")
	public List<Car> findAllCar(@PathVariable Integer id){
		
		return carService.findAllCar(id);
		
	}
	
	// 模拟接收汽车故障信息
	@RequestMapping("/findError/{error}")
	public String findError(@PathVariable String error) {
		
		String errorMsg = carService.findError(error);
				
		return errorMsg;
		
	}
}
