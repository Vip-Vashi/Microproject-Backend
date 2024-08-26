package com.micro.onlinebiddingsys.service;

import com.micro.onlinebiddingsys.model.Seller;

import java.util.List;

public interface SellerService {
    Seller saveSeller(Seller seller);
    Seller getSellerById(int id);
    List<Seller> getAllSellers();
    void deleteSeller(int id);
}