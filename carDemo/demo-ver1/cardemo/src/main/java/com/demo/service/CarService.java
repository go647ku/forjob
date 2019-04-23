package com.demo.service;

import com.demo.pojo.Car;

import java.util.List;



public interface CarService {

	void carRegister(String carId);

	List<Car> findAllCar(Integer id);

	String findError(String error);

}
