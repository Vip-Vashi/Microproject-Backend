package com.micro.onlinebiddingsys.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.repoimpl.ProductRepositoryImpl;
import com.micro.onlinebiddingsys.repoimpl.UserRepoimpl;


class ProductServiceImplTest {

	
	@Mock
	private ProductRepositoryImpl productRepository;
	
	@Mock
	private UserRepoimpl userRepoimpl;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@BeforeEach
	public void set() {
		MockitoAnnotations.openMocks(this);
	}
	
	
//	@Test
//	void testCreateProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateProduct() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testGetProductById() {
		    int productId = 1;
	        Product product = new Product();
	        when(productRepository.findById(productId)).thenReturn(product);

	        Product result = productServiceImpl.getProductById(productId);
	        assertNotNull(result);
	        assertEquals(product, result);
	        verify(productRepository, times(1)).findById(productId);
	}

	@Test
	void testDeleteProduct() {
		
		int productId = 1;
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(product);
        doNothing().when(productRepository).delete(product);

        productServiceImpl.deleteProduct(productId);
        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).delete(product);
		
		
	}

	@Test
	void testGetAllProducts() {
 
		List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productServiceImpl.getAllProducts();
        assertNotNull(result);
        assertEquals(products, result);
        verify(productRepository, times(1)).findAll();
	
	}

//	@Test
//	void testPlacebid() {
//		fail("Not yet implemented");
//	}

}
