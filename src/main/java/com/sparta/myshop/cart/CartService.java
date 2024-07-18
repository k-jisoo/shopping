package com.sparta.myshop.cart;

import com.sparta.myshop.cart.dto.CartItemResponseDto;
import com.sparta.myshop.cart.dto.CartItemResponseRequestDto;
import com.sparta.myshop.product.Product;
import com.sparta.myshop.product.ProductRepository;
import com.sparta.myshop.user.User;
import com.sparta.myshop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void addToCart(Long userId, Long productId, int quantity) {
        User user = userRepository.findById(userId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        cartRepository.save(new CartItem(user, product, quantity));
    }

    public CartItemResponseDto getCartInfo(Long userId) {
        List<CartItemResponseRequestDto> cartItemResponseRequestDto = cartRepository.findByUser_Id(userId).stream().map(CartItemResponseRequestDto::new).toList();

        return new CartItemResponseDto(cartItemResponseRequestDto);
    }

    public void updateQuantity(Long userId, Long productId, int quantity) {
        CartItem cartItem = cartRepository.findByUser_IdAndProduct_Id(userId, productId).orElseThrow();
        cartItem.UpdateQuantity(quantity);
        cartRepository.save(cartItem);
    }

    public void deleteProduct(Long userId, Long productId) {
        CartItem cartItem = cartRepository.findByUser_IdAndProduct_Id(userId, productId).orElseThrow();
        cartRepository.deleteById(cartItem.getId());
    }
}
