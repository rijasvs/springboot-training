package com.assignment.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.productservice.bean.Product;


/**
 * @author Rijas
 * 
 * Controller for product service
 */

@RestController
public class ProductController {

	static List<Product> products = new ArrayList<Product>();
	
	static {
		Product prod1 = new Product("1", "Mac");
		Product prod2 = new Product("2", "Windows");
		products.add(prod1);
		products.add(prod2);
	}

	/**
	 * Get all products
	 * 
	 * @return products
	 */
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return products;
	}
	
	/**
	 * Adding new product
	 * 
	 * @param product
	 * @return products
	 */
	@PostMapping("/products")
	public List<Product> addProduct(@Valid @RequestBody Product product) {
		Product pd3 = new Product(product.getId(), product.getName());
		products.add(pd3);
		return products;
	}
	
	/**
	 * deleting product based on id
	 * 
	 * @param id
	 * @return products
	 * @throws Exception
	 */
	@DeleteMapping("/products/{id}")
	public List<Product> deleteProduct(@PathVariable("id") String id) throws Exception{
		if(products.stream().anyMatch(product -> product.getId().equals(id))) {
			products.removeIf(product -> product.getId().equals(id));
		}else {
			throw new Exception("Product with id= "+id+" does not exist");
		}
		return products;
	}
	
	/**
	 * getting product based on id
	 * 
	 * @param id
	 * @return product
	 * @throws Exception
	 */
	@GetMapping("/products/product")
	public Product getroductById(@RequestParam(value = "id") String id) throws Exception {
		Product prod;
		if(products.stream().anyMatch(product -> product.getId().equals(id))) {
			prod = products.stream().filter(product -> product.getId().equals(id)).findAny().orElse(null);
		}else {
			throw new Exception("Product with id= "+id+" does not exist");
		}
		return prod;
	}

}
