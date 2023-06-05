package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    com.example.springboot.dto.Product findOneById(Long id);
    List<com.example.springboot.dto.Product> findOneByName(String name);
}
