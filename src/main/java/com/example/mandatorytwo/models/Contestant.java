package com.example.mandatorytwo.models;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Table(name = "Contestants")
@Entity
public class Contestant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int kills;

    @Column
    private int deaths;

    @Column
    private int assists;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Team team;

    @Enumerated(value = EnumType.STRING)
    @Column
    private FinalResult finalResult;

    @Enumerated(value = EnumType.STRING)
    @Column
    private TeamRole teamRole;

    @ManyToOne
    @JoinColumn(name = "champion_id")
    @Nullable
    private Champion champion;

    @ManyToOne
    @JoinColumn(name = "match_id")
    @Nullable
    private Match match;

    @ManyToOne
    @JoinColumn(name = "summoner_id")
    @Nullable
    private Summoner summoner;
}
