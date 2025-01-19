package com.pieroap.noriabarrotes.service;

import com.pieroap.noriabarrotes.dao.BuyProductRepository;
import com.pieroap.noriabarrotes.dao.ProductRepository;
import com.pieroap.noriabarrotes.model.BuyProduct;
import com.pieroap.noriabarrotes.model.Product;
import com.pieroap.noriabarrotes.user.User;
import com.pieroap.noriabarrotes.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyProductService {

    private final BuyProductRepository buyProductRegisterRepository;
    private final BuyProductRepository buyProductRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public BuyProduct registerBuyProduct(BuyProduct buyProductRegister) {
        Optional<User> userOpt = userRepository.findByUsername(buyProductRegister.getUser());
        Optional<Product> productOpt = productRepository.findByName(buyProductRegister.getProduct());
        System.out.println("User: " + userOpt);
        System.out.println("Product: " + userOpt);
        if (userOpt.isPresent() && productOpt.isPresent()) {
            User user = userOpt.get();
            Product product = productOpt.get();
            BuyProduct buyProduct = BuyProduct.builder()
                    .user(user.getUsername())
                    .product(product.getName())
                    .quantity(buyProductRegister.getQuantity())
                    .dateTime(LocalDateTime.now())
                    .build();
            return buyProductRepository.save(buyProduct);
        } else {
            throw new RuntimeException("User or Product not found");
        }
    }

    public List<BuyProduct> getAllBuyProducts() {
        return buyProductRegisterRepository.findAll();
    }
}