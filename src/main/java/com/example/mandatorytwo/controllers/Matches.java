package com.example.mandatorytwo.controllers;


import com.example.mandatorytwo.models.Match;
import com.example.mandatorytwo.repositories.ContestantRepository;
import com.example.mandatorytwo.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Matches {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    ContestantRepository contestants;

    @GetMapping("/matches")
    public Iterable<Match> getAllMatches(){
        return matchRepository.findAll();
    }

    @GetMapping("/matches/{matchId}")
    public Optional<Match> getMatchById(@PathVariable Long matchId){
        return matchRepository.findById(matchId);
    }

    @PostMapping("/matches")
    public Match addMatch(@RequestBody Match matchBody){
        return matchRepository.save(matchBody);
    }

    @PutMapping("/matches/{matchid}")
    public Match updateMatch(@PathVariable Long matchid, @RequestBody Match matchBody){
        matchBody.setMatchId(matchid);
        return matchRepository.save(matchBody);
    }

    @DeleteMapping("/matches/{matchid}")
    public void deleteMatch(@PathVariable Long matchid){
        matchRepository.deleteById(matchid);
    }
}
