package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table
@Entity
@ToString
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 2~6자리만 입력 가능
    @Size(min=2, max=6)
    @Column
    private String name;

    @Column
    private Long price;

    public Product() {

    }
}