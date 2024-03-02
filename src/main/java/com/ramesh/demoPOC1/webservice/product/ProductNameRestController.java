package com.ramesh.demoPOC1.webservice.product;

import org.springframework.web.bind.annotation.RestController;

import com.ramesh.demoPOC1.business.product.ProductNameService;
import com.ramesh.demoPOC1.data.model.ProductName;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class ProductNameRestController {
    @Autowired
    private ProductNameService productNameService;
    @GetMapping("/productname/{id}")
    public Optional<ProductName> getMethodName(@PathVariable long id) {
        return productNameService.getProduct(id);
    }
    
}
