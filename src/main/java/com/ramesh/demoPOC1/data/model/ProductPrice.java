package com.ramesh.demoPOC1.data.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ramesh.demoPOC1.data.pojo.Price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection="ProductPrice")
@Data
public class ProductPrice {
    private long id;
    private Price current_price;    
}
