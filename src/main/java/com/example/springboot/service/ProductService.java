package com.example.springboot.service;

import com.example.springboot.dto.Product;
import com.example.springboot.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final ProductJpaRepository productJpaRepository;

    public ProductService(ProductJpaRepository productJpaRepository) {

        this.productJpaRepository = productJpaRepository;
    }

    // 전체 상품 조회
    public List<com.example.springboot.entity.Product> findAll() {
        return productJpaRepository.findAll();
    }

    // id로 상품 조회
    public Product findOneById(Long id) {
        return productJpaRepository.findOneById(id);
    }

    // name 으로 상품 조회
    public List<Product> findOneByName(String name) {
        return productJpaRepository.findOneByName(name);
    }

    // 상품 등록 POST
    public void save(com.example.springboot.entity.Product product) {
        productJpaRepository.save(product);
    }

    // 상품 삭제 DELETE
    public void delete(Long id) {
        productJpaRepository.deleteById(id);
    }

    // 상품 업데이트 PUT
    public com.example.springboot.entity.Product update(Long id, com.example.springboot.entity.Product product) {
        com.example.springboot.entity.Product product1 = productJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productJpaRepository.save(product1);
    }

    // 상품 업데이트 PATCH
    public com.example.springboot.entity.Product patchUpdate(Long id, com.example.springboot.entity.Product product) {
        com.example.springboot.entity.Product product2 = productJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
        List<com.example.springboot.entity.Product>list = new ArrayList<>();
        list.add(product);
        for (int i=0;i< list.size();i++) {
            if (list.get(i).getName() != null) product2.setName(list.get(i).getName());
            if (list.get(i).getPrice() != null) product2.setPrice(list.get(i).getPrice());
        }
        return productJpaRepository.save(product2);
    }

}