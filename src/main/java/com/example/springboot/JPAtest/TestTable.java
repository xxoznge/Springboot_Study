package com.example.springboot.JPAtest;

import javax.persistence.*;

@Table
@Entity
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public TestTable() {
    }
}
