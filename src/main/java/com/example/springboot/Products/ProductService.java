package com.example.springboot.Products;
import com.example.springboot.dto.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductJpaRepository productJpaRepository;
    public ProductService(ProductRepository productRepository, ProductJpaRepository productJpaRepository) {

        this.productRepository = productRepository;
        this.productJpaRepository = productJpaRepository;
    }

    public List<com.example.springboot.Products.Product> findAll() {
        return productJpaRepository.findAll();
    }
    // ProductJpaRepository 사용하지않을때 전체 상품 조회
    // public List<Product> findAll() {
    //        return productJpaRepository.findAll();
    //    }

    public Product findOneById(int id) {
        return productRepository.findOneById(id);
    }

    public Product findOneByName(String name) {
        return productRepository.findOneByName(name);
    }

    public void save(com.example.springboot.Products.Product product) {
        productJpaRepository.save(product);
    }
}