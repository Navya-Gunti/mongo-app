package com.navya.mongo.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.navya.mongo.model.Car;
import com.navya.mongo.model.GeneralResponse;
import com.navya.mongo.service.CarService;

@WebMvcTest(Controller.class)
class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	private Car car;

	GeneralResponse result = new GeneralResponse();
	
	@BeforeEach
	void setup() {
		car = new Car("SampleDesc", 23, "SampleBrand", "20");
		result.setResult(car);
		result.setResponseMessage("Request processed successfully");

	}
	
	
	 @Test
	    public void getAllCars() throws Exception{
		 RequestBuilder request = MockMvcRequestBuilders
					.get("/cars/getAllItems")
					.accept(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(request)
					.andExpect(status().isOk())
					.andReturn();
		
	 }
	 
	}

