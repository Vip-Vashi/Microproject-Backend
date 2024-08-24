package com.micro.onlinebiddingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.onlinebiddingsys.model.AdministrativeUser;
import com.micro.onlinebiddingsys.model.Login;
import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.service.Adminservice;
import com.micro.onlinebiddingsys.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
    private Adminservice administrativeUserService;
 
    @Autowired
    private UserService customerService;
 
    @PostMapping
    public Object login(@RequestBody Login login) {
    	
        String email = login.getEmail();
        String password = login.getPassword();
 
        List<AdministrativeUser> admins = administrativeUserService.getAllAdministrativeUsers();
        for (AdministrativeUser admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return admin; 
            }
        }
 
        List<User> customers = customerService.getAllCustomers();
        for (User customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer; 
            }
        }
         return "Login failed: Invalid email or password";
    }
	
	

}
