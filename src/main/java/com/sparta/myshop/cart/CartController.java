package com.sparta.myshop.cart;

import com.sparta.myshop.cart.dto.CartItemResponseDto;
import com.sparta.myshop.cart.dto.CartItemResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok("상품이 장바구니에 추가되었습니다.");
    }

    @GetMapping("/{userId}")
    public CartItemResponseDto getCartInfo(@PathVariable Long userId) {
        return cartService.getCartInfo(userId);
    }

    @PutMapping("/{quantity}")
    public ResponseEntity<String> updateQuantity(@PathVariable Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.updateQuantity(userId, productId, quantity);
        return ResponseEntity.ok("상품의 수량이 수정되었습니다.");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.deleteProduct(userId, productId);
        return ResponseEntity.ok("상품이 삭제되었습니다.");
    }
}
