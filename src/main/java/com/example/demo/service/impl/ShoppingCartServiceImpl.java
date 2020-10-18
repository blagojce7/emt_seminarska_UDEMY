package com.example.demo.service.impl;

import com.example.demo.model.ShoppingCart;
import com.example.demo.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public ShoppingCart addProductToShoppingCart(Long userId, Long productId) {
        return null;
    }

    @Override
    public ShoppingCart removeProductFromShoppingCart(Long userId, Long productId) {
        return null;
    }

    @Override
    public List<ShoppingCart> findAllShoppingCarts() {
        return null;
    }
}
