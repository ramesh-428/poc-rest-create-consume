package com.ramesh.demoPOC1.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramesh.demoPOC1.data.model.ProductName;
@Repository
public interface ProductNameRepository extends CrudRepository<ProductName, Long> {
    
}
