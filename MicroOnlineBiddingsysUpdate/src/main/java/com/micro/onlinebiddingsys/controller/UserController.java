package com.micro.onlinebiddingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping()
	public User registerUser(@RequestBody User user) {
		userService.saveCustomer(user);
		return user;
	}

	@GetMapping("/all")
	public List<User> getAllCustomers() {
		return userService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public User getCustomerById(@PathVariable int id) {

		return userService.getCustomerById(id);
	}

	@PutMapping("/update/{id}")
	public void updateUser(@PathVariable int id, @RequestBody User user) {
		userService.updateCustomer(id, user);
	}

	@PutMapping("/updatewallet/{id}")
	public void updatewallet(@PathVariable("id") int id, @RequestParam("WalletAmt") double walletAmt) {
//		double walletAmt = Double.parseDouble(WalletAmt);
		userService.updatewallet(id, walletAmt);

	}

}
