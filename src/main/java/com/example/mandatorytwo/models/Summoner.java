package com.example.mandatorytwo.models;

import lombok.Data;

import javax.persistence.*;

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

}
