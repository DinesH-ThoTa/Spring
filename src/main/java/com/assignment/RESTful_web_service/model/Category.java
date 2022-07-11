package com.assignment.RESTful_web_service.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

	
	@Id
	public String name;
	private int ID;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	
}
