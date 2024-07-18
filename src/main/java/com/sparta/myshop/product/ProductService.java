package com.sparta.myshop.product;

import com.sparta.myshop.product.dto.ProductRequestDto;
import com.sparta.myshop.product.dto.ProductResponseDto;
import com.sparta.myshop.user.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productRepository.save(new Product(productRequestDto));

        return new ProductResponseDto(product);
    }

    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductResponseDto(product);
    }

    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).get();

        return new ProductResponseDto(product);
    }

    public Page<ProductResponseDto> getProducts(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productList = productRepository.findAll(pageable);

        return productList.map(ProductResponseDto::new);
    }
}
