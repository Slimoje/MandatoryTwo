package com.example.mandatorytwo.DTO;

import com.example.mandatorytwo.models.Contestant;
import com.example.mandatorytwo.enumAttributes.WinningTeam;
import com.example.mandatorytwo.models.Match;
import lombok.Data;

import java.util.Set;

@Data
public class MatchDTO {

    private Long matchId;
    private String startDate;
    private String startTime;
    private WinningTeam winningTeam;
    private Set<Contestant> contestants;

    public MatchDTO(Match match){
        matchId = match.getMatchId();
        startTime = match.getStartTime();
        startDate = match.getStartDate();
        winningTeam = getWinningTeam();
        contestants = match.getContestants();
    }

}
