package com.micro.onlinebiddingsys.service;

import java.util.List;

import com.micro.onlinebiddingsys.model.User;

public interface UserService {
	User saveCustomer(User user);
    User getCustomerById(int user);
    List<User> getAllCustomers();
    void deleteCustomerById(int uid);
    User updateCustomer(int uid, User user);
}
