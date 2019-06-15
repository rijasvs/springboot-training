package com.assignment.productservice.bean;

import javax.validation.constraints.NotBlank;

/**
 * @author Rijas
 * 
 * product model
 */

public class Product {

	@NotBlank(message = "id cannot be empty")
	String id;

	@NotBlank(message = "name cannot be empty")
	String name;

	public Product(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
