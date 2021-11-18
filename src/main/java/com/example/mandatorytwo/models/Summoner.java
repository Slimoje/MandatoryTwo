package com.example.mandatorytwo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="summoners")
@Entity
public class Summoner {

    @Id
    @Column
    private Long id;

    @Column
    private String summonerName;

    @Column
    private int summonerLevel;

    @JsonIgnore
    @OneToMany(mappedBy = "summoner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Contestant> contestants;

}
