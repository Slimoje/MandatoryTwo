package com.example.mandatorytwo.models;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.sql.Time;

@Data
@Table(name="Matches")
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long matchId;

    @Column
    private String startDate;

    @Column
    private String startTime;

    @Enumerated(value = EnumType.STRING)
    @Column
    private WinningTeam winningTeam;

}
