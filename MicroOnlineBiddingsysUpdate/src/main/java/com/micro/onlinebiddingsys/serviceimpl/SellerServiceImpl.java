package com.micro.onlinebiddingsys.serviceimpl;

import com.micro.onlinebiddingsys.model.Seller;
import com.micro.onlinebiddingsys.repoimpl.SellerRepoImpl;
import com.micro.onlinebiddingsys.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepoImpl sellerRepository;

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.saveSeller(seller);
    }

    @Override
    public Seller getSellerById(int id) {
        return sellerRepository.getSellerById(id);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.getAllSellers();
    }

    @Override
    public void deleteSeller(int id) {
        sellerRepository.deleteSeller(id);
    }
}