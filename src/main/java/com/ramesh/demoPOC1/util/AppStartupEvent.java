package com.ramesh.demoPOC1.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ramesh.demoPOC1.data.model.ProductPrice;
import com.ramesh.demoPOC1.data.repository.ProductPriceRepository;

import com.ramesh.demoPOC1.data.pojo.Price;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private ProductPriceRepository productPriceRepository;

    public AppStartupEvent(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository=productPriceRepository;
    }
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.productPriceRepository.deleteAll();
        Price priceObj = new Price(9.99, "USD");
        ProductPrice productPriceObj = new ProductPrice(13860428, priceObj);
        this.productPriceRepository.save(productPriceObj);
        priceObj = new Price(6.99, "USD");
        productPriceObj= new ProductPrice(13264003, priceObj);
        this.productPriceRepository.save(productPriceObj);
        priceObj = new Price(1.29, "USD");
        productPriceObj= new ProductPrice(12954218, priceObj);
        this.productPriceRepository.save(productPriceObj);
    }
}
