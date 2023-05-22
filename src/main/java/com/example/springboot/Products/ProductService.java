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


    public com.example.springboot.Products.Product update(Long id, com.example.springboot.Products.Product product) {
        com.example.springboot.Products.Product product1 = productJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));

        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productJpaRepository.save(product1);
    }
    public void delete(Long id) {
        productJpaRepository.deleteById(id);
    }
}