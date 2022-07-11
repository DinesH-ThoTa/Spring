package com.assignment.RESTful_web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.RESTful_web_service.model.Product;

@Repository
public interface Product_repository extends JpaRepository<Product, Integer> {

}
