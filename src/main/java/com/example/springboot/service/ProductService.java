package com.example.springboot.service;

import com.example.springboot.repository.ProductJpaRepository;
import com.example.springboot.repository.ProductRepository;
import com.example.springboot.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductJpaRepository productJpaRepository;

    public ProductService(ProductRepository productRepository, ProductJpaRepository productJpaRepository) {

        this.productRepository = productRepository;
        this.productJpaRepository = productJpaRepository;
    }

    public List<com.example.springboot.entity.Product> findAll() {
        return productJpaRepository.findAll();
    }
    public Product findOneById(int id) {
        return productRepository.findOneById(id);
    }

    public Product findOneByName(String name) {
        return productRepository.findOneByName(name);
    }

    public void save(com.example.springboot.entity.Product product) {
        productJpaRepository.save(product);
    }


    public com.example.springboot.entity.Product update(Long id, com.example.springboot.entity.Product product) {
        com.example.springboot.entity.Product product1 = productJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productJpaRepository.save(product1);
    }
    public void delete(Long id) {
        productJpaRepository.deleteById(id);
    }
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