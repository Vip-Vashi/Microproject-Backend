package com.micro.onlinebiddingsys.service;

import java.util.List;

import com.micro.onlinebiddingsys.model.Winner;

public interface WinnerService {
	public Winner createWinner(Winner winner);
	  public Winner updateWinner(Winner winner) ;
	  public Winner getWinnerById(int id);
	  public void deleteWinner(int id) ;
	  public List<Winner> getAllWinners();
}
