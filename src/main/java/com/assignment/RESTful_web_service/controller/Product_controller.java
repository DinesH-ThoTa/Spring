package com.assignment.RESTful_web_service.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.RESTful_web_service.exception.EmptyList;
import com.assignment.RESTful_web_service.model.Product;
import com.assignment.RESTful_web_service.service.Product_Service;


@RestController
@RequestMapping("/product")
public class Product_controller {
	
	@Autowired
	Product_Service service;
	

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getproducts()
	{
		List<Product> list=service.getProducts();
		if(list.isEmpty()) throw new EmptyList();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable int id)
	{
		Product p=service.findProductById(id);
		if(p==null) throw new NoSuchElementException();

		return ResponseEntity.status(HttpStatus.FOUND).body(p);	
	}
	
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Product> addproduct(@RequestBody Product product)
	{
		service.addproduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	
	
	
	@PutMapping("/update/{id}") 
	public ResponseEntity<Void> updateproduct(@RequestBody Product p,@PathVariable int id)
	{
		if(!service.updateproduct(p,id))  throw new NoSuchElementException();
		service.updateproduct(p, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteproduct(@PathVariable int id)
	{
		if(!service.deleteproduct(id))  throw new NoSuchElementException();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
