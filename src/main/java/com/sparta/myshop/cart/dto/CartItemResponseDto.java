package com.sparta.myshop.cart.dto;

import com.sparta.myshop.cart.CartItem;
import lombok.Getter;

import java.util.List;

@Getter
public class CartItemResponseDto {
    private List<CartItem> cartItems;
    private int sumPrice;

    public CartItemResponseDto(List<CartItem> cartItems) {
        this.cartItems = cartItems;

        cartItems.forEach(cartItem -> {
            this.sumPrice += cartItem.getProduct().getPrice();
        });
    }
}
