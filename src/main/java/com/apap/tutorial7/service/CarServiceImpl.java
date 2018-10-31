package com.apap.tutorial7.service;
import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * CarServiceImpl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;

	@Override
	public CarModel addCar(CarModel car) {
		// TODO Auto-generated method stub
		return carDb.save(car);
		
	}

	@Override
	public List<CarModel> sortByPriceDesc(Long dealer_id) {
		// TODO Auto-generated method stub
		return carDb.findByDealerIdOrderByPriceDesc(dealer_id);
	}

	@Override
	public void deleteCar(CarModel car) {
		// TODO Auto-generated method stub
		carDb.delete(car);
		
	}

	@Override
	public CarModel getCar(long id) {
		// TODO Auto-generated method stub
		return carDb.findById(id).get();
	}

	@Override
	public void updateCar(Long id, String brand, String type, Long price, Integer amount) {
		// TODO Auto-generated method stub
		CarModel updateCar = carDb.getOne(id);
		updateCar.setAmount(amount);
		updateCar.setBrand(brand);
		updateCar.setPrice(price);
		updateCar.setType(type);
		carDb.save(updateCar);
	}

	@Override
	public Optional<CarModel> getCarDetailById(long id) {
		// TODO Auto-generated method stub
		return carDb.findById(id);
	}

	@Override
	public List<CarModel> viewAllCar() {
		// TODO Auto-generated method stub
		return carDb.findAll();
	}

}
