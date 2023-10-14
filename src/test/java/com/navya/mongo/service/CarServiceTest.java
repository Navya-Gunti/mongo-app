package com.navya.mongo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.navya.mongo.model.Car;
import com.navya.mongo.model.CarRepository;

@SpringBootTest
class CarServiceTest {
	
	@Autowired
	private CarService carService;
	
	@MockBean
	private CarRepository carRepository;
	
	@BeforeEach
	void setUp() {
		Optional<Car> car =  Optional.of(new Car("description", 30000, "brand", "2"));
		Mockito.when(carRepository.findById("2")).thenReturn(car);
	}
	
	@Test
	public void testGetCarById_Success() {
		Optional<Car> car= carRepository.findById("2");
		assertEquals("brand", car.get().getBrand());
	}

}
