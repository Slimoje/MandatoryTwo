package com.example.mandatorytwo.controllers;


import com.example.mandatorytwo.DTO.MatchDTO;
import com.example.mandatorytwo.models.Contestant;
import com.example.mandatorytwo.models.Match;
import com.example.mandatorytwo.repositories.ContestantRepository;
import com.example.mandatorytwo.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Matches {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    ContestantRepository contestants;

    @GetMapping("/matches")
    public Iterable<MatchDTO> getAllMatches(){
        List<Match> matches = matchRepository.findAll();
        List<MatchDTO> matchDTOs = new ArrayList<>();
        for (Match match:matches) {
            matchDTOs.add(new MatchDTO(match));
        }
        return matchDTOs;
    }

    @GetMapping("/matches/{matchId}")
    public MatchDTO getMatchById(@PathVariable Long matchId){
        Match match = matchRepository.findById(matchId).get();
        MatchDTO matchDTO = new MatchDTO(match);
        System.out.println(match.getWinningTeam());
        System.out.println(matchDTO.getWinningTeam());
        return matchDTO;
    }

    @PostMapping("/matches")
    public MatchDTO addMatch(@RequestBody Match matchBody){
        Match match = matchRepository.save(matchBody);
        MatchDTO matchDTO = new MatchDTO(match);
        return matchDTO;
    }

    @PutMapping("/matches/{matchid}")
    public MatchDTO updateMatch(@PathVariable Long matchid, @RequestBody Match matchBody){
        matchBody.setMatchId(matchid);
        contestants.saveAll(matchBody.getContestants());
        Match match = matchRepository.save(matchBody);
        MatchDTO matchDTO = new MatchDTO(match);
        return matchDTO;
    }

    @DeleteMapping("/matches/{matchid}")
    public void deleteMatch(@PathVariable Long matchid){
        matchRepository.deleteById(matchid);
    }
}
