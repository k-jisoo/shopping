package com.sparta.myshop.product.dto;

import com.sparta.myshop.product.Product;
import com.sparta.myshop.product.ProductCategory;
import com.sparta.myshop.product.ProductRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String name;
    private int price;
    private int amount;
    private String description;
    private ProductCategory productCategory;

    public ProductResponseDto(){

    }

    public ProductResponseDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.description = product.getDescription();
        this.productCategory = product.getProductCategory();
    }
}
