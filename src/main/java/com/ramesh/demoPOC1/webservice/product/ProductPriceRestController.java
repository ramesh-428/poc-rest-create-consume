package com.ramesh.demoPOC1.webservice.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramesh.demoPOC1.business.product.ProductPriceService;
import com.ramesh.demoPOC1.data.model.ProductPrice;

@RestController
@RequestMapping("/api")
public class ProductPriceRestController {
    @Autowired
    private ProductPriceService productPriceService;

    @PostMapping("/productprice")
    public void addDoc(@RequestBody ProductPrice productPrice) {
        productPriceService.addDocument(productPrice);
    }

    @GetMapping("/productprice/{id}")
    public Optional<ProductPrice> getDoc(@PathVariable long id) {
        return productPriceService.getDocument(id);
    }
}
