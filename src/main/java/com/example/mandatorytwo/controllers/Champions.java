package com.example.mandatorytwo.controllers;

import com.example.mandatorytwo.models.Champion;
import com.example.mandatorytwo.repositories.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Champions {

    @Autowired
    ChampionRepository championRepository;

    @GetMapping("/champions")
    public Iterable<Champion> getAllChampions(){
        return championRepository.findAll();
    }

    @GetMapping("/champions/{championId}")
    public Champion getChampionById(@PathVariable Long championId){
        return championRepository.findById(championId).get();
    }

}
