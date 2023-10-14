package com.navya.mongo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



	@SpringBootTest
	public class CarRepositoryTest {
		
		@MockBean
		private CarRepository carRepository;
		
		@BeforeEach
		void setUp() {
			Optional<Car> car =  Optional.of(new Car("description", 30000, "brand", "2"));
			Mockito.when(carRepository.findById("2")).thenReturn(car);
			List<Car> cars = new ArrayList<>();
			cars.add(car.get());
			Mockito.when(carRepository.findAll()).thenReturn(cars);
		}
		
		
		@Test
		public void testFindAll() {
			List<Car> cars = carRepository.findAll();
			assertEquals(1,cars.size());
		}

		@Test
		public void testFindOne() {
			Car car = carRepository.findById("2").get();
			System.out.println(car.getBrand());
			assertEquals("brand",car.getBrand());
		}

	}


