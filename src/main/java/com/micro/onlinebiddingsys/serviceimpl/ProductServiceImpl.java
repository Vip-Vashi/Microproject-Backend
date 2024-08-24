package com.micro.onlinebiddingsys.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.repoimpl.ProductRepositoryImpl;
import com.micro.onlinebiddingsys.repoimpl.UserRepoimpl;
import com.micro.onlinebiddingsys.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryImpl productRepository;
    
    @Autowired
    private UserRepoimpl userRepoimpl;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.update(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(int id) {
        Product product = getProductById(id);
        if (product != null) {
            productRepository.delete(product);
        }
    }

    public List<Product> getAllProducts() {
    	return productRepository.findAll();
       
    }

	@Override
	public void placebid(int productId, int userID, Double currentBiddingPrice) {
		
		Product product = productRepository.findById(productId);
		product.setCurrentBiddingPrice(currentBiddingPrice);
		product.setProductstatus("On Auction");
		User user = userRepoimpl.findById(userID);
		product.setUser(user);
		productRepository.update(product);
		
	}
}