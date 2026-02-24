package com.ecommerce.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.user.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}