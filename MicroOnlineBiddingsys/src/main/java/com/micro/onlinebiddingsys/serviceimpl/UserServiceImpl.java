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
		// TODO Auto-generated method stub
		
		return repo.save(user);
	}

	@Override
	public User getCustomerById(int uid) {
		// TODO Auto-generated method stub
		return repo.findById(uid);
	}

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteCustomerById(int uid) {
		// TODO Auto-generated method stub
		repo.delete(uid);
	}

	@Override
	public User updateCustomer(int uid, User user) {
		// TODO Auto-generated method stub
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
