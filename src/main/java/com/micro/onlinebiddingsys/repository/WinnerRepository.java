package com.micro.onlinebiddingsys.repository;

import com.micro.onlinebiddingsys.model.Winner;

public interface WinnerRepository {
	public Winner save(Winner winner);
	 public Winner update(Winner winner) ;
	 public Winner findById(int id) ;
	 public void delete(Winner winner);
}
