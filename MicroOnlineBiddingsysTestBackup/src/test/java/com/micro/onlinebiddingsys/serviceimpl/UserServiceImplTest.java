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
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.repository.UserRepo;

@SpringBootTest
class UserServiceImplTest {

	@Mock
	private UserRepo repo;
	
	@InjectMocks
	private UserServiceImpl userService;
	@BeforeEach
	public void set() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	void testSaveCustomer() {
		    User user = new User(0,"Vashanth","tsv@gmail.com","tsv1234","8901234565","Madurai",12000,null,"user");
	        when(repo.save(user)).thenReturn(user);

	        User result = userService.saveCustomer(user);
	        assertNotNull(result);
	        assertEquals(user, result);
	        verify(repo, times(1)).save(user);
	}

	
	@Test
	void testGetCustomerById() {
		 int userId = 1;
	        User user = new User(1,"Abi","abi123@gmail.com","abi123","98012134243","Trichy",10000,null,"user");
	        when(repo.findById(userId)).thenReturn(user);

	        User result = userService.getCustomerById(userId);
	        assertNotNull(result);
	        assertEquals(user, result);
	        verify(repo, times(1)).findById(userId);
	}

	@Test
	void testGetAllCustomers() {
		
		    List<User> users = new ArrayList<>();
	        when(repo.findAll()).thenReturn(users);

	        List<User> result = userService.getAllCustomers();
	        assertNotNull(result);
	        assertEquals(users, result);
	        verify(repo, times(1)).findAll();
	}

	@Test
	void testDeleteCustomerById() {
		int userId = 1;
        doNothing().when(repo).delete(userId);

        userService.deleteCustomerById(userId);
        verify(repo, times(1)).delete(userId);
	}

	@Test
	void testUpdateCustomer() {
		int userId = 1;
        User user = new User(1,"Abi","abi@gmail.com","abi123","9012352678","Trichy",20000,null,"user");
        when(repo.findById(userId)).thenReturn(user);
        when(repo.update(user)).thenReturn(user);

        User result = userService.updateCustomer(userId, user);
        assertNotNull(result);
        assertEquals(user, result);
        verify(repo, times(1)).findById(userId);
        verify(repo, times(1)).update(user);
	}

	@Test
	void testUpdatewallet() {
		int userId = 1;
        double newWalletAmt = 19000.0;
        User user = new User();
        when(repo.findById(userId)).thenReturn(user);
        when(repo.update(user)).thenReturn(user);

        userService.updatewallet(userId, newWalletAmt);
        assertEquals(newWalletAmt, user.getWalletAmt());
        verify(repo, times(1)).findById(userId);
        verify(repo, times(1)).update(user);
	}

}
