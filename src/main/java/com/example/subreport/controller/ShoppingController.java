package com.example.subreport.controller;

import com.example.subreport.request.ShoppingRequest;
import com.example.subreport.response.FetchCartResponse;
import com.example.subreport.service.IShoppingCart;
import com.example.subreport.util.ReportService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin
@Slf4j
public class ShoppingController {

    @Autowired
    private IShoppingCart shoppingCart;
    @Autowired
    private ReportService reportService;
    @PostMapping("/saveInToCart")
    public void saveDataToCart(@RequestBody ShoppingRequest request){
       log.info("Saving data for shopping cart");
       shoppingCart.saveToShoppingCart(request);
    }

    @GetMapping()
    public FetchCartResponse fetchCartDetails(@RequestParam("id") int id){
        log.info("Fetching items...");
        return shoppingCart.fetchCartDetails(id);
    }

    @GetMapping("/report")
    public String generateReport(@RequestParam("format") String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
