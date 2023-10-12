package com.navya.mongo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navya.mongo.model.Car;
import com.navya.mongo.model.CarRepository;

@Service
public class CarService {
	
	 @Autowired
	 CarRepository repo;
	
	  public List<Car> getAllCars() {
	        List<Car> cars = new ArrayList<>();
	        repo.findAll().forEach(cars::add); 
	       return cars.stream()
	        .sorted(Comparator.comparing(Car::getPrice).reversed())
	        .collect(Collectors.toList());
	    }
	  
	  public Car getCar(String id) {
		  return repo.findByItemId(id);
	  }

}
