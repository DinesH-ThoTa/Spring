package com.assignment.RESTful_web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.RESTful_web_service.model.Category;

@Repository
public interface Category_repo extends JpaRepository<Category, String> {

}

