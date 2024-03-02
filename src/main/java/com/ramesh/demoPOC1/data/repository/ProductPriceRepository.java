package com.ramesh.demoPOC1.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ramesh.demoPOC1.data.model.ProductPrice;

@Repository
public interface ProductPriceRepository extends MongoRepository<ProductPrice, Long> {
}
