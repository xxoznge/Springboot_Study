package com.example.springboot.Products;

import org.springframework.stereotype.Repository;
import com.example.springboot.dto.Product;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private static final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("노트북", 3000L));
        products.add(new Product("키보드", 2000L));
        products.add(new Product( "마우스", 1000L));
    }

    // 전체 상품을 조회하는 메소드
    public List<Product> findAll() {
        return products;
    }

    // id를 기준으로 상품 하나를 조회하는 메소드
    public Product findOneById(Integer id) {
        return products.get(id);
    }

    // 이름을 기준으로 상품 하나를 조회하는 메소드
    public Product findOneByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findAny()
                .orElseThrow();
    }
    // 상품 저장 메소드
    public void save(Product product) {
        products.add(product);
    }

}
