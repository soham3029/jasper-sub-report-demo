package com.example.subreport.response;

import com.example.subreport.dto.ItemSelectedDTO;
import com.example.subreport.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchCartResponse {
    private String firstName;
    private String lastName;
    private List<Item> items;
}
