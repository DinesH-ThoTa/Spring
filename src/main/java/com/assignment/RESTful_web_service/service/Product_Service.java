package com.assignment.RESTful_web_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

import com.assignment.RESTful_web_service.model.Category;
import com.assignment.RESTful_web_service.model.Product;
import com.assignment.RESTful_web_service.repository.Category_repo;
import com.assignment.RESTful_web_service.repository.Product_repository;


@Component

public class Product_Service
{

	@Autowired
	Product_repository pro_repo;
	
	@Autowired
	Category_repo cat_repo;
	
	public List<Product> getProducts()
	{
		List<Product> list=this.pro_repo.findAll();
		return list;
	}
	
	public Product findProductById(int id)
	{
		Product p=this.pro_repo.findById(id).get();
		return p;
	}
	
	public Product addproduct(Product p)
	{
		Product added=pro_repo.save(p);
		return added;
	}
	
	public boolean updateproduct(Product p, int id)
	{
		if(pro_repo.existsById(id))
		{
			p.setProduct_id(id);
			pro_repo.save(p);
			return true;
		}
		return false;
	}
	
	
	public boolean deleteproduct(int id)
	{
		if(pro_repo.existsById(id))
		{
		pro_repo.deleteById(id);
		return true;
		}
		return false;
	}
	
	
	@Bean
	public void data()
	{
		//Category table
		Category c1=new Category();
		c1.setID(9);
		c1.setName("Mobile");
		this.cat_repo.save(c1);
		
		
		//Product Table
		Product p1=new Product();
		p1.setCategory(c1);
		p1.setProduct_id(1);
		p1.setPrice(1000);
		p1.setProduct_name("OnePlus");
		this.pro_repo.save(p1);
	}
	
}

