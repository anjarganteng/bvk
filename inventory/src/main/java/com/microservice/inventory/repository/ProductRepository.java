package com.microservice.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
