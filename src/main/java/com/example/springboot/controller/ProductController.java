package com.example.springboot.controller;

import com.example.springboot.dto.Product;
import com.example.springboot.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 조회
    @GetMapping("api/product")
    public List<com.example.springboot.entity.Product> findAll() { return productService.findAll(); }

    //id로 상품 조회
    @GetMapping(value = "api/product", params = "id")
    public Product findOneById(@RequestParam Long id) {
        return productService.findOneById(id);
    }

    // name 으로 상품 조회
    @GetMapping(value = "api/products", params = "name")
    public Product findOneByName(@RequestParam String name) {
        return productService.findOneByName(name);
    }
    // 상품 등록
    @PostMapping("api/product")
    public String saveProduct(@RequestBody com.example.springboot.entity.Product product) {
        productService.save(product);
        return "정상 저장됐습니다.";
    }

    // 상품 삭제
    @DeleteMapping("api/product/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "삭제되었습니다.";
    }

    // 상품 수정
    @PutMapping ("api/product/{id}")
    public String update(@PathVariable Long id,@RequestBody com.example.springboot.entity.Product product) {
        productService.update(id,product);
        return "수정되었습니다.";
    }

    // 상품 일부 수정
    @PatchMapping("api/product/{id}")
    public String patchUpdate(@PathVariable Long id,@RequestBody com.example.springboot.entity.Product product) {
        productService.patchUpdate(id, product);
        return "일부 수정되었습니다.";
    }


}
