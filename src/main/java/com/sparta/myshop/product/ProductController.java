package com.sparta.myshop.product;

import com.sparta.myshop.product.dto.ProductRequestDto;
import com.sparta.myshop.product.dto.ProductResponseDto;
import com.sparta.myshop.security.UserDetailsImpl;
import com.sparta.myshop.user.UserRoleEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Secured(UserRoleEnum.Authority.ADMIN)
    @PostMapping("/create")
    public ProductResponseDto createProduct(@RequestBody @Valid ProductRequestDto productRequestDto, BindingResult bindingResult){
        // Validation 예외처리
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(!fieldErrors.isEmpty()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return new ProductResponseDto();
        }

        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return productService.getProducts(page-1, size, sortBy, sortOrder);
    }
}
