package com.example.subreport.dao;

import com.example.subreport.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartDAO extends JpaRepository<ShoppingCart, Long> {
}
