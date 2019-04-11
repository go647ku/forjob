package com.car.service;

import java.util.List;

import com.car.pojo.Car;

public interface CarService {

	void carRegister(String carId);

	List<Car> findAllCar(Integer id);

	String findError(String error);

}
