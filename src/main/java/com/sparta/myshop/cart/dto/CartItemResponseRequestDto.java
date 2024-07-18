package com.sparta.myshop.cart.dto;

import com.sparta.myshop.cart.CartItem;
import com.sparta.myshop.product.Product;
import lombok.Getter;

@Getter
public class CartItemResponseRequestDto {
    private Long userId;
    private Product product;

    public CartItemResponseRequestDto(CartItem cartItem) {
        this.userId = cartItem.getUser().getId();
        this.product = cartItem.getProduct();
    }
}
