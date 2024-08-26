package com.micro.onlinebiddingsys.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.model.Winner;
import com.micro.onlinebiddingsys.repoimpl.ProductRepositoryImpl;
import com.micro.onlinebiddingsys.repoimpl.WinnerRepositoryImpl;
import com.micro.onlinebiddingsys.service.WinnerService;

@Service
public class WinnerServiceImpl implements WinnerService{

	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	
	 @Autowired
	    private WinnerRepositoryImpl winnerRepository;

	    @Override
	    public Winner createWinner(Winner winner) {
	    	Product product =  productRepositoryImpl.findById(winner.getProduct().getProductId());
	    	product.setProductstatus("Sold");
	    	winner.setProduct(product);
//            product.getUser().setWalletAmt(product.getUser().getWalletAmt() - product.getCurrentBiddingPrice());
	        return winnerRepository.save(winner);
	    }

	    @Override
	    public Winner updateWinner(Winner winner) {
	        return winnerRepository.update(winner);
	    }

	    @Override
	    public Winner getWinnerById(int id) {
	        return winnerRepository.findById(id);
	    }

	    @Override
	    public void deleteWinner(int id) {
	        Winner winner = getWinnerById(id);
	        if (winner != null) {
	            winnerRepository.delete(winner);
	        }
	    }

	    @Override
	    public List<Winner> getAllWinners() {
	    	
	    	return winnerRepository.findAllWins();
	        // Assuming the EntityManager-based repository doesn't have a findAll method
	        // Implement a custom query if necessary
	    }
}
