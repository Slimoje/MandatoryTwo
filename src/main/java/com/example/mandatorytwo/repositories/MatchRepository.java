package com.example.mandatorytwo.repositories;

import com.example.mandatorytwo.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
