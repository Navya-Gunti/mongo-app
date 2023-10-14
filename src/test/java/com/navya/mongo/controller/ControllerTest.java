package com.navya.mongo.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.navya.mongo.model.Car;
import com.navya.mongo.service.CarService;

@WebMvcTest(Controller.class)
class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	private Car car;

	@BeforeEach
	void setup() {
		car = new Car("SampleDesc", 23, "SampleBrand", "20");
	}

}