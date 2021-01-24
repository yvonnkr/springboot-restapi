package com.yvolabs.springrestapi.services;

import com.yvolabs.springrestapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
