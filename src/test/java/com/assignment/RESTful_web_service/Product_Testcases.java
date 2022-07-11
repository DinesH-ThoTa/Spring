package com.assignment.RESTful_web_service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.RESTful_web_service.model.Category;
import com.assignment.RESTful_web_service.model.Product;
import com.assignment.RESTful_web_service.repository.Category_repo;
import com.assignment.RESTful_web_service.repository.Product_repository;
import com.assignment.RESTful_web_service.service.Product_Service;

@SpringBootTest

@TestMethodOrder(OrderAnnotation.class)
class Product_Testcases {

	@Autowired
	Product_repository pro_repo;
	
	@Autowired
	Category_repo cat_repo;
	
	@Autowired
	Product_Service service;
	
	@Test
	@Order(1)
	public void testCreate()
	{
		Category c=new Category();
		c.setID(10);
		c.setName("Laptop");
		cat_repo.save(c);
		
		Product p=new Product();
		p.setProduct_id(3);
		p.setProduct_name("Hp");
		p.setPrice(10000);
		p.setCategory(c);
		pro_repo.save(p);
		assertNotNull(service.findProductById(3),"user not created");
	}
	
	@Test
	@Order(2)
	public void testGetall()
	{
		List<Product> list=service.getProducts();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	public void testUpdate()
	{
		Product p=service.findProductById(3);
		p.setPrice(9000);
		pro_repo.save(p);
		assertEquals(9000, service.findProductById(3).getPrice());
	}
	
	@Test
	@Order(4)
	public void testDelete()
	{
		service.deleteproduct(3);
		assertFalse(pro_repo.existsById(3));
	}

}
