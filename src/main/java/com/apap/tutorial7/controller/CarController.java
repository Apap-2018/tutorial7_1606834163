package com.apap.tutorial7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.CarService;

/*
 * CarController
 */
@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	@PutMapping(value="/{id}")
	private String updateCarSubmit(
			@PathVariable (value="id", required=false) long id,
			@RequestParam(value="brand", required=false) String brand,
			@RequestParam(value="type", required=false) String type,
			@RequestParam(value="price", required=false) Long price,
			@RequestParam(value="amount", required=false) Integer amount,
			@RequestParam(value="dealerId", required=false) Long dealerId
			) {
		CarModel car = (CarModel) carService.getCarDetailById(id).get();
		if(car.equals(null)) {
			return "Couldn't fint your dealer";
		}
		car.setBrand(brand);
		car.setType(type);
		car.setPrice(price);
		car.setAmount(amount);
		return "Car update Success";
	}
	
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		return carService.addCar(car);
	}
	
	@GetMapping(value="/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarDetailById(carId).get();
	}
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model){
		return carService.viewAllCar();
	}
	
	@DeleteMapping(value="/delete")
	private String deleteCar(@RequestParam("carId") long id, Model model) {
		CarModel car = carService.getCarDetailById(id).get();
		carService.deleteCar(car);
		return "Car has been delete";
	}

}

