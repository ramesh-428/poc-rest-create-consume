package com.ramesh.demoPOC1.webservice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramesh.demoPOC1.business.product.ProductService;
import com.ramesh.demoPOC1.data.model.ProductPrice;
import com.ramesh.demoPOC1.data.pojo.Product;
import com.ramesh.demoPOC1.exception.ProductNotFoundException;



@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.getProductByID(id);
    }

    @PostMapping("/products/{id}")
    public ProductPrice updateProduct(@PathVariable("id") long id, @RequestBody ProductPrice price) throws ProductNotFoundException {
        return productService.updatePrice(price);
    }

}
