package com.simplilearn.trg.jdbc.service;

import java.sql.PreparedStatement;
import java.util.Set;

import com.simplilearn.trg.jdbc.dao.ProductDao;
import com.simplilearn.trg.jdbc.dao.ProductDaoImpl;
import com.simplilearn.trg.jdbc.dto.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDao dao;
	
	public ProductServiceImpl() {
		dao = new ProductDaoImpl();
	}
	@Override
	public boolean addProduct(Product product) {
		return dao.addProduct(product);
	}

	@Override
	public boolean updateProductCost(int productId, double productCost) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public Product searchProductById(int productId) {
		return dao.searchProductById(productId);
	}

	@Override
	public Set<Product> searchProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
