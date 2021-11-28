package com.example.mandatorytwo.repositories;

import com.example.mandatorytwo.models.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerRepository extends JpaRepository<Summoner, String> {
}
