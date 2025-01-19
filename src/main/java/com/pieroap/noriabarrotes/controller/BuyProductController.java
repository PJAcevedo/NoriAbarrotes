package com.pieroap.noriabarrotes.controller;
import com.pieroap.noriabarrotes.dao.ProductRepository;
import com.pieroap.noriabarrotes.model.BuyProduct;
import com.pieroap.noriabarrotes.model.Product;
import com.pieroap.noriabarrotes.service.BuyProductService;
import com.pieroap.noriabarrotes.user.User;
import com.pieroap.noriabarrotes.user.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buy/product")
public class BuyProductController {
    private final BuyProductService buyProductService;

    public BuyProductController(BuyProductService buyProductService) {
        this.buyProductService = buyProductService;
    }

    @GetMapping
    public List<BuyProduct> getAllBuyProducts() {
        return buyProductService.getAllBuyProducts();
    }

    @PostMapping("/register")
    public BuyProduct registerBuyProduct(@RequestBody BuyProduct buyProductRegister) {
        return buyProductService.registerBuyProduct(buyProductRegister);
    }

}
