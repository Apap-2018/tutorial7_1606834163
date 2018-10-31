package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;
/*
 * CarService
 */
public interface CarService {
	CarModel addCar(CarModel car);
	List<CarModel> sortByPriceDesc(Long dealer_id);
	void deleteCar(CarModel car);
	CarModel getCar(long id);
	void updateCar(Long id, String brand, String type, Long price, Integer amount);
	Optional<CarModel> getCarDetailById(long id);
	List<CarModel> viewAllCar();

}
