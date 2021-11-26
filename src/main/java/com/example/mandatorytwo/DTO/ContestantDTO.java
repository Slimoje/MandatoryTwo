package com.example.mandatorytwo.DTO;

import com.example.mandatorytwo.enumAttributes.FinalResult;
import com.example.mandatorytwo.enumAttributes.Team;
import com.example.mandatorytwo.enumAttributes.TeamRole;
import com.example.mandatorytwo.models.*;
import lombok.Data;

@Data
public class ContestantDTO {

    private Long id;
    private int kills;
    private int deaths;
    private int assists;
    private Team team;
    private FinalResult finalResult;
    private TeamRole teamRole;
    private Champion champion;
    private Match match;
    private Summoner summoner;

}
