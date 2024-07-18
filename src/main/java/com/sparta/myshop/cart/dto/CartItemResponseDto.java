package com.sparta.myshop.cart.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CartItemResponseDto {
    private List<CartItemResponseRequestDto> cartItemResponseRequestDtos;
    private int sum;

    public CartItemResponseDto(List<CartItemResponseRequestDto> cartItemResponseRequestDtos) {
        this.cartItemResponseRequestDtos = cartItemResponseRequestDtos;

        for(CartItemResponseRequestDto cartItemResponseRequestDto : cartItemResponseRequestDtos){
            this.sum += cartItemResponseRequestDto.getProduct().getPrice();
        }
    }
}
