package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    com.example.springboot.dto.Product findOneById(Long id);
    com.example.springboot.dto.Product findOneByName(String name);
}
