package com.micro.onlinebiddingsys.serviceimpl;

import com.micro.onlinebiddingsys.model.Biddings;
import com.micro.onlinebiddingsys.repoimpl.BidderRepoImpl;

import com.micro.onlinebiddingsys.service.BiddingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingsServiceImpl implements BiddingService {

    @Autowired
    private BidderRepoImpl biddingsRepository;

    @Override
    public Biddings saveBidding(Biddings bidding) {
        return biddingsRepository.saveBidding(bidding) ;
    }

    @Override
    public Biddings getBiddingById(int id) {
        return biddingsRepository.getBiddingById(id);
        
    }

    @Override
    public List<Biddings> getAllBiddings() {
        return biddingsRepository.getAllBiddings();
    }

    @Override
    public void deleteBidding(int id) {
        biddingsRepository.deleteBidding(id);
    }
}