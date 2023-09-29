package com.example.guessplayerbackend.entity.dto;

import com.example.guessplayerbackend.entity.ClubEntity;
import com.example.guessplayerbackend.entity.LeagueEntity;

public class LeagueClubObject {
    private ClubEntity clubEntity;
    private LeagueEntity leagueEntity;

    public LeagueClubObject(ClubEntity clubEntity, LeagueEntity leagueEntity) {
        this.clubEntity = clubEntity;
        this.leagueEntity = leagueEntity;
    }

    public LeagueClubObject() {
    }

    public ClubEntity getClubEntity() {
        return clubEntity;
    }

    public void setClubEntity(ClubEntity clubEntity) {
        this.clubEntity = clubEntity;
    }

    public LeagueEntity getLeagueEntity() {
        return leagueEntity;
    }

    public void setLeagueEntity(LeagueEntity leagueEntity) {
        this.leagueEntity = leagueEntity;
    }

    @Override
    public String toString() {
        return "LeagueClubObject{" +
                "clubEntity=" + clubEntity +
                ", leagueEntity=" + leagueEntity +
                '}';
    }
}
