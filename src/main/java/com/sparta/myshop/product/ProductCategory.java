package com.sparta.myshop.product;

public enum ProductCategory {
    A(Category.A),
    B(Category.B),
    C(Category.C);

    private final String categoryName;

    ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String categoryName() {
        return this.categoryName;
    }

    public static class Category {
        public static final String A = "A";
        public static final String B = "B";
        public static final String C = "C";
    }
}