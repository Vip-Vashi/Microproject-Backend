package com.micro.onlinebiddingsys.repository;

import java.util.List;

import com.micro.onlinebiddingsys.model.Product;

public interface ProductRepository {
	public Product save(Product product) ;
	  public Product update(Product product);
	  public Product findById(int id);
	  public void delete(Product product);
	  public List<Product> findAll();
}
