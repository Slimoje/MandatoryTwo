package com.example.mandatorytwo.controllers;


import com.example.mandatorytwo.models.Match;
import com.example.mandatorytwo.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Matches {

    @Autowired
    MatchRepository matchRepository;

    @GetMapping("/matches")
    public Iterable<Match> getAllMatches(){
        return matchRepository.findAll();
    }

    @GetMapping("/matches/{matchid}")
    public Match getMatchById(@PathVariable Long matchid){
        return matchRepository.findById(matchid).get();
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
