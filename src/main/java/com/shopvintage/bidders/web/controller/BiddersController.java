package com.shopvintage.bidders.web.controller;

import com.shopvintage.bidders.persistence.entities.Bidder;
import com.shopvintage.bidders.persistence.repositories.BidderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bidders")
public class BiddersController {

    @Autowired
    private BidderRepository bidderRepository;

    @GetMapping
    public List<Bidder> findAll(){
        return bidderRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Bidder> save(@RequestBody Bidder bidder){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bidderRepository.save(bidder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bidder> findById(@PathVariable Integer id){
        var bidder = this.bidderRepository.findById(id).orElse(null);
        return ResponseEntity.ok(bidder);
    }
}
