package com.navya.mongo.model;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface CarRepository extends MongoRepository<Car,String > {
	 public Car findByItemId(String itemId);
}
