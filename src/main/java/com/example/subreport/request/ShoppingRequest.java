package com.example.subreport.request;

import com.example.subreport.dto.ItemSelectedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingRequest {
    private String firstName;
    private String lastName;
    private List<ItemSelectedDTO> itemSelectedDTOS;
}
