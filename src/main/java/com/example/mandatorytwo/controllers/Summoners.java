package com.example.mandatorytwo.controllers;

import com.example.mandatorytwo.models.Summoner;
import com.example.mandatorytwo.repositories.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Summoners {

    @Autowired
    SummonerRepository summoners;

    @GetMapping("/summoners")
    public Iterable<Summoner> getSummoners() {
        return summoners.findAll();
    }

    @GetMapping("/summoners/{id}")
    public Summoner getArtistById(@PathVariable Long id) {
        return summoners.findById(id).get();
    }

    @PostMapping("/summoners")
    public Summoner addSummoner(@RequestBody Summoner newSummoner) {
        newSummoner.setId(null);
        return summoners.save(newSummoner);
    }

    @PutMapping("/summoners/{id}")
    public String updateSummonerById(@PathVariable Long id, @RequestBody Summoner summonerToUpdateWith) {
        if (summoners.existsById(id)) {
            summonerToUpdateWith.setId(id);
            summoners.save(summonerToUpdateWith);
            return "Summoner was updated";
        } else {
            return "Summoner not found";
        }
    }

    @PatchMapping("/summoners/{id}")
    public String patchSummonerById(@PathVariable Long id, @RequestBody Summoner summonerToUpdateWith) {
        return summoners.findById(id).map(foundSummoner -> {
            if(summonerToUpdateWith.getSummonerName() != null) foundSummoner.setSummonerName(summonerToUpdateWith.getSummonerName());
            if(summonerToUpdateWith.getSummonerLevel() != 0) foundSummoner.setSummonerLevel(summonerToUpdateWith.getSummonerLevel());

            summoners.save(foundSummoner);
            return "Summoner was patched";
        }).orElse("Summoner not found");
    }

    @DeleteMapping("/summoners/{id}")
    public String deleteSummonerById(@PathVariable Long id) {
        if(summoners.existsById(id)) {
            String deletedName = summoners.findById(id).get().getSummonerName();
            summoners.deleteById(id);
            return (deletedName + "was deleted");
        } else {
            return "Summoner not found";
        }
    }
}
