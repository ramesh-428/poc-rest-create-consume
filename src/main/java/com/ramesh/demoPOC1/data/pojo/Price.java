package com.ramesh.demoPOC1.data.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {
    private double value;
    private String currency_code;
}
