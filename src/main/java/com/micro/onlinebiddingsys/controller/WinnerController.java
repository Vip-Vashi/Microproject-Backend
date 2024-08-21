package com.micro.onlinebiddingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/winners")
@CrossOrigin("*")

public class WinnerController {

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
}