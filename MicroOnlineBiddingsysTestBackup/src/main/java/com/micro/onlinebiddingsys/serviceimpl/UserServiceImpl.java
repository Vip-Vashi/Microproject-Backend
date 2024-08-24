package com.micro.onlinebiddingsys.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.repository.UserRepo;
import com.micro.onlinebiddingsys.service.UserService;

@Service
public class UserServiceImpl implements UserService {
@Autowired 
private UserRepo repo;
	@Override
	public User saveCustomer(User user) {
		
		return repo.save(user);
	}

	@Override
	public User getCustomerById(int uid) {
		return repo.findById(uid);
	}

	@Override
	public List<User> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public void deleteCustomerById(int uid) {
		repo.delete(uid);
	}

	@Override
	public User updateCustomer(int uid, User user) {
        if (repo.findById(uid) != null) {
            user.setUid(uid);
            return repo.update(user);
        }
        return null;
	}

	@Override
	public void updatewallet(int id, double walletAmt) {
		
		User user = repo.findById(id);
	    user.setWalletAmt(walletAmt);
	    repo.update(user);
	}
	

}
