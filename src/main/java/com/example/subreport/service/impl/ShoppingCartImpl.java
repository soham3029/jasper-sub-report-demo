package com.example.subreport.service.impl;

import com.example.subreport.dao.ItemDAO;
import com.example.subreport.dao.ShoppingCartDAO;
import com.example.subreport.dto.ItemSelectedDTO;
import com.example.subreport.model.Item;
import com.example.subreport.model.ShoppingCart;
import com.example.subreport.request.ShoppingRequest;
import com.example.subreport.response.FetchCartResponse;
import com.example.subreport.service.IShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ShoppingCartImpl implements IShoppingCart {

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Override
    public void saveToShoppingCart(ShoppingRequest request) {
        ShoppingCart cart = new ShoppingCart();
        List<Item> items = new ArrayList<>();
        cart.setFirstName(request.getFirstName());
        cart.setLastName(request.getLastName());
        cart.setDop(new Date());
        items = createDataForItems(cart, request);
        cart.setListOfItems(items);
        shoppingCartDAO.save(cart);
        log.info("Data saved successfully");
    }

    @Override
    public FetchCartResponse fetchCartDetails(int id) {
        FetchCartResponse response = new FetchCartResponse();
        ShoppingCart cart = shoppingCartDAO.getById((long) id);
        response.setFirstName(cart.getFirstName());
        response.setLastName(cart.getLastName());
        response.setItems(cart.getListOfItems());
        return response;
    }

    private List<Item> createDataForItems(ShoppingCart cart, ShoppingRequest request) {
        List<Item> items = new ArrayList<>();
        for(ItemSelectedDTO dto: request.getItemSelectedDTOS()){
            Item item = new Item();
            item.setItemName(dto.getItemName());
            item.setPrice(dto.getPrice());
            item.setNoOfUnits(dto.getNumberOfUnits());
            items.add(item);
        }
        items = itemDAO.saveAll(items);
        return items;
    }
}
