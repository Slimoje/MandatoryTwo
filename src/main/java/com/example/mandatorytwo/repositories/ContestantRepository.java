package com.example.mandatorytwo.repositories;

import com.example.mandatorytwo.models.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestantRepository extends JpaRepository<Contestant, Long> {
}
