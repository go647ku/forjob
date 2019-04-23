package com.demo.service;

import java.util.Date;
import java.util.List;

import com.demo.mapper.CarMapper;
import com.demo.mapper.UserMapper;
import com.demo.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarMapper carMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void carRegister(String carId) {
		
		// 暂时用李哥作为user
		Car car = new Car();
		
		Integer uid = 1;
		
		car.setcId(carId);
		car.setuId(uid);
		car.setError("00000000");
		car.setCreated(new Date());
		
		car.setUpdated(car.getCreated());
		
		carMapper.insert(car);
		
		
	}

	@Override
	public List<Car> findAllCar(Integer id) {
		
		return carMapper.selectList(new QueryWrapper<Car>().eq("u_id", id));
		
	}

	@Override
	public String findError(String error) {
		StringBuilder stringBuilder = new StringBuilder("");
		// 传过来的是长度为8的字符串
		// 1.字符串遍历
		for(int i = 0; i < error.length(); i++) {
			
			int errornum = Integer.valueOf(error.charAt(i)+"");
			
			if(errornum==1) {
				
				switch (
						i) {
				case 1:
					stringBuilder.append("发动机故障"+" ");
					break;
				case 2:	
					stringBuilder.append("催化转化器故障"+" ");
					break;
					
				case 3:
					stringBuilder.append("颗粒捕集器故障"+" ");
					break;
					
				case 4:
					stringBuilder.append("氧传感器故障"+" ");
					break;
					
				case 5:
					stringBuilder.append("排放控制系统故障"+" ");
					break;
					
				case 6:
					stringBuilder.append("燃油系统故障"+" ");
					break;
					
				case 7:
					stringBuilder.append("EGR故障"+" ");
					break;
				}
				
			}
			
		}
		
		return stringBuilder.toString().trim();
	}
	
}
