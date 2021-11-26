package com.example.mandatorytwo.DTO;

import com.example.mandatorytwo.models.Contestant;
import com.example.mandatorytwo.enumAttributes.WinningTeam;
import lombok.Data;

import java.util.Set;

@Data
public class MatchDTO {

    private Long matchId;
    private String startDate;
    private String startTime;
    private WinningTeam winningTeam;
    private Set<Contestant> contestants;

}
