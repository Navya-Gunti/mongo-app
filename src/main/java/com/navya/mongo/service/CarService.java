package com.navya.mongo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navya.mongo.model.Car;
import com.navya.mongo.model.CarRepository;
import com.navya.mongo.model.GeneralResponse;

@Service
public class CarService {

	@Autowired
	CarRepository repo;

	public ResponseEntity<GeneralResponse> getAllCars() {
		List<Car> cars = new ArrayList<>();
		ResponseEntity<GeneralResponse> response = null;
		GeneralResponse result = new GeneralResponse();
		try {
			repo.findAll().forEach(cars::add);
			cars = cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).collect(Collectors.toList());

			if (cars == null) {
				result.setResponseMessage("No records in the database");
				response = new ResponseEntity<GeneralResponse>(result, HttpStatus.NOT_FOUND);
				return response;
			} else {
				result.setResponseMessage("Request processed successfully");
				result.setResult(cars);
				response = new ResponseEntity<GeneralResponse>(result, HttpStatus.OK);
				return response;

			}
		} catch (Exception e) {
			result.setResponseMessage("Exception Occured in /product/showAll");
			result.setErrorMessage(e.getMessage());
			response = new ResponseEntity<GeneralResponse>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	public ResponseEntity<GeneralResponse> getCar(String id) {

		ResponseEntity<GeneralResponse> response = null;
		GeneralResponse result = new GeneralResponse();
		Car car = null;
		try {
			car = repo.findByItemId(id);

			if (car == null) {
				result.setResponseMessage("No records in the database");
				response = new ResponseEntity<GeneralResponse>(result, HttpStatus.NOT_FOUND);
				return response;
			} else {
				result.setResponseMessage("Request processed successfully");
				result.setResult(car);
				response = new ResponseEntity<GeneralResponse>(result, HttpStatus.OK);
				return response;

			}
		} catch (Exception e) {
			result.setResponseMessage("Exception Occured in getbyId");
			result.setErrorMessage(e.getMessage());
			response = new ResponseEntity<GeneralResponse>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}

	}

}
