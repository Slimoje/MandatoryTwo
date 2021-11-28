package com.example.mandatorytwo.repositories;

import com.example.mandatorytwo.models.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContestantRepository extends JpaRepository<Contestant, Long> {
    Set<Contestant> findContestantsByMatch_MatchId(Long matchId);

    Iterable<Contestant> findContestantsBySummoner_SummonerId(String summonerId);
}
