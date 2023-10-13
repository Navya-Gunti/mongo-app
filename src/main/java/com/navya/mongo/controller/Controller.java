package com.navya.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navya.mongo.model.GeneralResponse;
import com.navya.mongo.service.CarService;


@RestController
public class Controller {
	
	
	@Autowired
	CarService service;
	
	 @RequestMapping({"/cars/getAllItems"})
	    public ResponseEntity<GeneralResponse> getAllCars(){
		 return service.getAllCars();
	 }
	 
	 @RequestMapping({"/cars/find/{id}"})
	  public ResponseEntity<GeneralResponse> getCar(@PathVariable String id){
		return service.getCar(id);
	 }
}
