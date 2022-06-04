package com.simplilearn.trg.jdbc.client;

import java.util.Set;

import com.simplilearn.trg.jdbc.dto.Product;
import com.simplilearn.trg.jdbc.service.ProductService;
import com.simplilearn.trg.jdbc.service.ProductServiceImpl;

public class Client {
	public static void main(String[] args) {
		Product product = new Product(5, "Laptopn", 40000);
		
		ProductService service = new ProductServiceImpl();
		boolean isProductAdded = service.addProduct(product);
		if(isProductAdded == true)
			System.out.println("Product added successfully");
		else
			System.out.println("Product not added");
		System.out.println("********************************************");
		Set<Product> allProducts = service.getAllProducts();
		for (Product prod : allProducts) {
			System.out.println(prod);
		}
		System.out.println("********************************************");
		Product product2 = service.searchProductById(13);
		if(product2 != null)
			System.out.println(product2);
		else 
			System.out.println("Product not found");
	}
}
