package com.ramesh.demoPOC1.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Table (name="PRODUCT_NAME")
@Entity
@Data
public class ProductName {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private long id;
    @Column(name="NAME")
    private String name;
}
