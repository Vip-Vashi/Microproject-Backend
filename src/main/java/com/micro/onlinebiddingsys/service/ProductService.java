package com.micro.onlinebiddingsys.service;

import java.util.List;

import com.micro.onlinebiddingsys.model.Product;

public interface ProductService {
	 public Product createProduct(Product product) ;
	 public Product updateProduct(Product product);
	 public Product getProductById(int id) ;
	 public void deleteProduct(int id) ;
	 public List<Product> getAllProducts() ;
     public void placebid(int productId, int userID, Double currentBiddingPrice);
}
