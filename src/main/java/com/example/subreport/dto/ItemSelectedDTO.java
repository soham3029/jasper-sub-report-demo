package com.example.subreport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemSelectedDTO {
    private String itemName;
    private float price;
    private int numberOfUnits;

}
