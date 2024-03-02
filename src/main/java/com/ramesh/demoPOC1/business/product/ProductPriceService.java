package com.ramesh.demoPOC1.business.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ramesh.demoPOC1.data.model.ProductPrice;
import com.ramesh.demoPOC1.data.repository.ProductPriceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductPriceService {
    @Autowired
    private final ProductPriceRepository productPriceRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
public void addDocument(ProductPrice productprice){
    productPriceRepository.save(productprice);
}
public Optional<ProductPrice> getDocument(long id){
    return productPriceRepository.findById(id);
}
public void updateDocument(ProductPrice productPrice){
   Query query = Query.query(Criteria.where("id").is(productPrice.getId())); 
     mongoTemplate.replace(query,productPrice);
}

}