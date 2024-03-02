package com.ramesh.demoPOC1.business.product;

import java.util.Optional;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ramesh.demoPOC1.data.GlobalVariables;
import com.ramesh.demoPOC1.data.model.ProductPrice;
import com.ramesh.demoPOC1.data.pojo.Product;
import com.ramesh.demoPOC1.data.pojo.ProductNameRecord;
import com.ramesh.demoPOC1.exception.ProductNotFoundException;

@Service
public class ProductService {
    private final ProductPriceService productPriceService;
    private final RestTemplate restTemplate;
    public ProductService(RestTemplateBuilder builder, ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
        restTemplate = builder.build();
    }

    public Product getProductByID(long id) throws ProductNotFoundException {
        ProductNameRecord productName = restTemplate.getForObject(GlobalVariables.REST_URL+ id, ProductNameRecord.class);
        Optional<ProductPrice> productPrice = productPriceService.getDocument(id);
        Product product = new Product();
        if (productPrice.isPresent() && (productName.name()!=null)) {
            product.setId(id);
            product.setName(productName.name());
            product.setCurrent_price(productPrice.get().getCurrent_price());
            return product;
        } else throw new ProductNotFoundException("Product Name not found for Id:"+id);
        
    }
    public ProductPrice updatePrice(ProductPrice price) throws ProductNotFoundException {
        Optional<ProductPrice> productPrice = productPriceService.getDocument(price.getId());
        if (productPrice.isPresent()) {
            ProductPrice price1=productPrice.get();
            price1.setCurrent_price(price.getCurrent_price());
            productPriceService.updateDocument(price1);
            return price1;
        } else throw new ProductNotFoundException("Product Name not found for Id:"+price.getId()  );
        
    }
}
