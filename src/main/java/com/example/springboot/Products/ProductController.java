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
    public List<com.example.springboot.Products.Product> findAll() { return productService.findAll(); }
    // ProductJpaRepository 사용하지않을때 전체 상품 조회
    // public List<Product> findAll() { return productService.findAll(); }
    @GetMapping(value = "api/products", params = "id")
    public Product findOneById(@RequestParam int id) {
        return productService.findOneById(id);
    }

    @GetMapping(value = "api/products", params = "name")
    public Product findOneByName(@RequestParam String name) {
        return productService.findOneByName(name);
    }

    @PostMapping("api/products")
    public String saveProduct(@RequestBody com.example.springboot.Products.Product product) {
        productService.save(product);
        return "정상 저장됐습니다.";
    }

    @PutMapping ("api/products/{id}")
    public String update(@PathVariable Long id,@RequestBody com.example.springboot.Products.Product product) {
        productService.update(id,product);
        return "수정되었습니다.";
    }

    @DeleteMapping("api/products/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "삭제되었습니다.";
    }

    @PatchMapping("api/products/{id}")
    public String patchUpdate(@PathVariable Long id,@RequestBody com.example.springboot.Products.Product product) {
        productService.patchUpdate(id, product);
        return "일부 수정되었습니다.";
    }


}
