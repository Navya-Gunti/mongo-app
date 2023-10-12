package com.navya.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navya.mongo.model.Car;
import com.navya.mongo.model.GeneralResponse;
import com.navya.mongo.service.CarService;

import jakarta.websocket.server.PathParam;


@RestController
public class Controller {
	
	
	@Autowired
	CarService service;
	
	 @RequestMapping({"/cars/getAllItems"})
	    public ResponseEntity<GeneralResponse> getAllCars(){
	    	ResponseEntity<GeneralResponse> response = null;
	    	GeneralResponse result = new GeneralResponse();
	    	try {
	    		List<Car> itemList = service.getAllCars();
	    		
	        	
	        	if(itemList == null) {
	        		result.setResponseMessage("No records in the database");
	        		response = new ResponseEntity<GeneralResponse>(result, HttpStatus.OK);
	        		return response;
	        	}
	        	else {
	        		result.setResponseMessage("Request processed successfully");
	            	result.setResult(itemList);
	        		response = new ResponseEntity<GeneralResponse>(result, HttpStatus.OK);
	        		return response;
	        		
	        	}
	    	}
	    	catch(Exception e) {
	    		result.setResponseMessage("Exception Occured in /product/showAll");
	    		result.setErrorMessage(e.getMessage());
	    		response = new ResponseEntity<GeneralResponse>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	    		return response;
	    	}
	    	
	    }
	 
	 @RequestMapping({"/cars/find/{id}"})
	  public ResponseEntity<GeneralResponse> getCar(@PathVariable String id){
	    	ResponseEntity<GeneralResponse> response = null;
	    	GeneralResponse result = new GeneralResponse();
	    	try {
	    		//List<Car> itemList = service.getAllCars();
	    		Car object = service.getCar(id);
	        	
	        	if(object == null) {
	        		result.setResponseMessage("No records in the database");
	        		response = new ResponseEntity<GeneralResponse>(result, HttpStatus.OK);
	        		return response;
	        	}
	        	else {
	        		result.setResponseMessage("Request processed successfully");
	            	result.setResult(object);
	        		response = new ResponseEntity<GeneralResponse>(result, HttpStatus.OK);
	        		return response;
	        		
	        	}
	    	}
	    	catch(Exception e) {
	    		result.setResponseMessage("Exception Occured in getbyId");
	    		result.setErrorMessage(e.getMessage());
	    		response = new ResponseEntity<GeneralResponse>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	    		return response;
	    	}
	    	
	    }
}
