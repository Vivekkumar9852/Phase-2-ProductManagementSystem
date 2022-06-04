package com.simplilearn.trg.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.simplilearn.trg.jdbc.dto.Product;
import com.simplilearn.trg.jdbc.util.ConnectionManagerImpl;

public class ProductDaoImpl implements ProductDao{
	private Connection connection;
	
	public ProductDaoImpl() {
		connection = new ConnectionManagerImpl().getConnection();
	}
	@Override
	public boolean addProduct(Product product) {
		boolean isProductAdded = false;
		
		String query = "insert into products values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getProductCost());
			
			int val = preparedStatement.executeUpdate();
			
			if(val > 0)
				isProductAdded = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return isProductAdded;
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
		Set<Product> products = new HashSet<Product>();
		try {
			Statement statement = connection.createStatement();
			String query = "select * from products";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
//				Product product = new Product();
//				product.setProductId(resultSet.getInt(1));
//				product.setProductName(resultSet.getString(2));
//				product.setProductCost(resultSet.getDouble(3));
//				products.add(product);
//				System.out.println(resultSet.getInt(1));
//				System.out.println(resultSet.getString(2));
//				System.out.println(resultSet.getDouble(3));
				Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product searchProductById(int productId) {
		Product product = null;
		String sql = "select * from products where product_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Set<Product> searchProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
