package com.example.mandatorytwo.controllers;

import com.example.mandatorytwo.models.Contestant;
import com.example.mandatorytwo.repositories.ContestantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Contestants {

    @Autowired
    ContestantRepository contestants;

    @GetMapping("/contestants")
    public Iterable<Contestant> getAllContestants(){
        return contestants.findAll();
    }

    @GetMapping("/contestants/{contestantId}")
    public Optional<Contestant> getContestantById(@PathVariable Long contestantId){
        return contestants.findById(contestantId);
    }

    @PostMapping("/contestants")
    public Contestant addContestant(@RequestBody Contestant contestantBody){
        return contestants.save(contestantBody);
    }

    @PutMapping("/contestants/{contestantId}")
    public Contestant updateContestant(@PathVariable Long contestantId, @RequestBody Contestant contestantBody){
        contestantBody.setId(contestantId);
        return contestantBody;
    }

    @DeleteMapping("/contestants/{contestantId}")
    public void deleteContestant(@PathVariable Long contestantId){
        contestants.deleteById(contestantId);
    }
}
