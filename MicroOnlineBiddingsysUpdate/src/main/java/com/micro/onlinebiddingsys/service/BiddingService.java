package com.micro.onlinebiddingsys.service;
import com.micro.onlinebiddingsys.model.Biddings;

import java.util.List;

public interface BiddingService {
    Biddings saveBidding(Biddings bidding);
    Biddings getBiddingById(int id);
    List<Biddings> getAllBiddings();
    void deleteBidding(int id);
}