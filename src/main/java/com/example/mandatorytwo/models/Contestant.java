package com.example.mandatorytwo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

//@Data
//The @Data has been removed because it causes a stack overflow error when trying to get a
//list of Contestants

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

    public Contestant() {
    }

    public Contestant(Long id, int kills, int deaths, int assists, Team team, FinalResult finalResult, TeamRole teamRole, @Nullable Champion champion, @Nullable Match match, @Nullable Summoner summoner) {
        this.id = id;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.team = team;
        this.finalResult = finalResult;
        this.teamRole = teamRole;
        this.champion = champion;
        this.match = match;
        this.summoner = summoner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public FinalResult getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(FinalResult finalResult) {
        this.finalResult = finalResult;
    }

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }

    @Nullable
    public Champion getChampion() {
        return champion;
    }

    public void setChampion(@Nullable Champion champion) {
        this.champion = champion;
    }

    @Nullable
    public Match getMatch() {
        return match;
    }

    public void setMatch(@Nullable Match match) {
        this.match = match;
    }

    @Nullable
    public Summoner getSummoner() {
        return summoner;
    }

    public void setSummoner(@Nullable Summoner summoner) {
        this.summoner = summoner;
    }
}
