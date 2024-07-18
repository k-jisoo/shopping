package com.sparta.myshop.product.dto;

import com.sparta.myshop.product.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private int price;
    private int amount;
    private String description;
    private ProductCategory productCategory;
}
