package com.micro.onlinebiddingsys.repository;

import java.util.List;

import com.micro.onlinebiddingsys.model.User;

public interface UserRepo {
	  public void delete(int id);
	  public List<User> findAll() ;
	  public User update(User user);
	  public User save(User user);
	  public User findById(int id);
	  
}
