package com.ramesh.demoPOC1.business.product;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ramesh.demoPOC1.data.model.ProductName;
import com.ramesh.demoPOC1.data.repository.ProductNameRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductNameService {
    private final ProductNameRepository productNameRepository;
    public Optional<ProductName> getProduct(long id){
        return productNameRepository.findById(id);
    }
}
