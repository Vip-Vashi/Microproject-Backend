package com.micro.onlinebiddingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.onlinebiddingsys.model.Winner;
import com.micro.onlinebiddingsys.service.WinnerService;
import com.micro.onlinebiddingsys.serviceimpl.EmailService;

@RestController
@RequestMapping("/winners")
@CrossOrigin("http://localhost:3000")

public class WinnerController {

	@Autowired
	private EmailService emailService;
	
	
    @Autowired
    private WinnerService winnerService;

    @PostMapping
    public Winner createWinner(@RequestBody Winner winner) {
        return winnerService.createWinner(winner);
    }

    @PutMapping("/{id}")
    public Winner updateWinner(@PathVariable int id, @RequestBody Winner winner) {
        winner.setId(id);
        return winnerService.updateWinner(winner);
    }

    @GetMapping("/{id}")
    public Winner getWinnerById(@PathVariable int id) {
        return winnerService.getWinnerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWinner(@PathVariable int id) {
        winnerService.deleteWinner(id);
    }

    @GetMapping("/all")
    public List<Winner> getAllWinners() {
        return winnerService.getAllWinners();
    }
    
    @PostMapping("/sendmail")
    public ResponseEntity<String> sendWinnerEmail(@RequestBody Winner request) {
        try {
            // Extract details from the request
            String recipientEmail = request.getProduct().getUser().getEmail();
            String winner = request.getProduct().getUser().getUsername();
            String productName = request.getProduct().getName();
            String winningPrice = Double.toString(  request.getProduct().getCurrentBiddingPrice());

            // Create email subject and body
            String subject = "Congratulations! You Won the Auction!";
            String text = String.format("Dear %s,\n\nCongratulations! You have won the auction for the product '%s' with a winning bid of %s.\n\nThank you for participating!\n\nBest Regards,\n AAA Auction Team",winner, productName, winningPrice);

            // Send the email
            emailService.sendEmail(recipientEmail, subject, text);

            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
}