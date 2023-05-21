package com.example.springboot.Products;

import org.springframework.web.bind.annotation.*;
import com.example.springboot.dto.Product;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("api/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "api/products", params = "id")
    public Product findOneById(@RequestParam int id) {
        return productService.findOneById(id);
    }

    @GetMapping(value = "api/products", params = "name")
    public Product findOneByName(@RequestParam String name) {
        return productService.findOneByName(name);
    }


}
