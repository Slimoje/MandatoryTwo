package com.example.mandatorytwo.repositories;

import com.example.mandatorytwo.models.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository extends JpaRepository<Champion, Long> {
}
