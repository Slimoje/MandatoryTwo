package com.example.mandatorytwo.models;

import lombok.Data;

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
    private Enum team;

    @Column
    private Enum finalResult;
}
