package com.assignment.RESTful_web_service.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Id
	private int product_id;
	private String product_name;
	private double price;
	
	@JsonBackReference
	@ManyToOne
	private Category category;
	
	
}
