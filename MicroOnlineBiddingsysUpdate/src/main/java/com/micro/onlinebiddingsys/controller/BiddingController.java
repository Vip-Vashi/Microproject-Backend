package com.micro.onlinebiddingsys.controller;

import com.micro.onlinebiddingsys.model.Biddings;
import com.micro.onlinebiddingsys.service.BiddingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/biddings")
public class BiddingController {

    @Autowired
    private BiddingService biddingsService;

    @PostMapping
    public ResponseEntity<Biddings> createBidding(@RequestBody Biddings bidding) {
        return ResponseEntity.ok(biddingsService.saveBidding(bidding));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biddings> getBiddingById(@PathVariable int id) {
        Biddings bidding = biddingsService.getBiddingById(id);
        if (bidding != null) {
            return ResponseEntity.ok(bidding);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Biddings>> getAllBiddings() {
        return ResponseEntity.ok(biddingsService.getAllBiddings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBidding(@PathVariable int id) {
        biddingsService.deleteBidding(id);
        return ResponseEntity.noContent().build();
    }
}