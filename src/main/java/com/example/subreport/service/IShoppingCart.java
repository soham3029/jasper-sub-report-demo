package com.example.subreport.service;

import com.example.subreport.request.ShoppingRequest;
import com.example.subreport.response.FetchCartResponse;

public interface IShoppingCart {
    public void saveToShoppingCart(ShoppingRequest request);
    public FetchCartResponse fetchCartDetails(int id);
}
