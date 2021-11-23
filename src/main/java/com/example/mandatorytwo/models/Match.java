package com.example.mandatorytwo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "match", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Contestant> contestants;

}
