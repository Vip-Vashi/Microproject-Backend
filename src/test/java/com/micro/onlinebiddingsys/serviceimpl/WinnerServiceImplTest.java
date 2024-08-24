package com.micro.onlinebiddingsys.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.model.Winner;
import com.micro.onlinebiddingsys.repoimpl.ProductRepositoryImpl;
import com.micro.onlinebiddingsys.repoimpl.WinnerRepositoryImpl;

class WinnerServiceImplTest {

	@Mock
	private ProductRepositoryImpl productRepositoryImpl;
	
	@Mock
	private WinnerRepositoryImpl winnerRepository;
	
	@InjectMocks
	private WinnerServiceImpl winnerServiceImpl; 
	
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
//	@Test
//	void testCreateWinner() {
//		
//		Product product = new Product();
//        product.setProductId(1);
//        product.setProductstatus("Available");
//        product.setCurrentBiddingPrice(100.0);
//
//        User user = new User();
//        user.setWalletAmt(500.0);
//        product.setUser(user);
//
//        Winner winner = new Winner();
//        winner.setProduct(product);
////        winner.setUser(user);
//
//        when(productRepositoryImpl.findById(any(Integer.class))).thenReturn(product);
//        when(winnerRepository.save(any(Winner.class))).thenReturn(winner);
//
//        // Act
//        Winner result = winnerServiceImpl.createWinner(winner);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("Sold", product.getProductstatus());
//        assertEquals(400.0, user.getWalletAmt());
//        verify(productRepositoryImpl).findById(product.getProductId());
//        verify(winnerRepository).save(winner);
//
//		
//	}

//	@Test
//	void testUpdateWinner() {
//
//		 Winner winner = new Winner();
//	        when(winnerRepository.update(any(Winner.class))).thenReturn(winner);
//
//	        // Act
//	        Winner result = winnerServiceImpl.updateWinner(winner);
//
//	        // Assert
//	        assertNotNull(result);
//	        verify(winnerRepository).update(winner);
//	}

	@Test
	void testGetWinnerById() {
		
		    Winner winner = new Winner();
	        when(winnerRepository.findById(any(Integer.class))).thenReturn(winner);

	        // Act
	        Winner result = winnerServiceImpl.getWinnerById(1);

	        // Assert
	        assertNotNull(result);
	        verify(winnerRepository).findById(1);
	}

//	@Test
//	void testDeleteWinner() {
//
//	}

	@Test
	void testGetAllWinners() {

		    Winner winner = new Winner();
	        List<Winner> winners = Collections.singletonList(winner);
	        when(winnerRepository.findAllWins()).thenReturn(winners);

	        List<Winner> result = winnerServiceImpl.getAllWinners();

	        
	        assertNotNull(result);
	        assertFalse(result.isEmpty());
	        assertEquals(1, result.size());
	        verify(winnerRepository).findAllWins();
		
	}

}
