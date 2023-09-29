package com.example.guessplayerbackend.entity.dto;

public class NationalityLeagueName {
   private String natinalityUrl;
   private String leagueUrl;

   private String leagueName;

   private String nationName;


    public NationalityLeagueName(String natinalityUrl, String leagueUrl, String leagueName, String nationName) {
        this.natinalityUrl = natinalityUrl;
        this.leagueUrl = leagueUrl;
        this.leagueName = leagueName;
        this.nationName = nationName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public NationalityLeagueName() {

    }

    public String getNatinalityUrl() {
        return natinalityUrl;
    }

    public void setNatinalityUrl(String natinalityUrl) {
        this.natinalityUrl = natinalityUrl;
    }

    public String getLeagueUrl() {
        return leagueUrl;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setLeagueUrl(String leagueUrl) {
        this.leagueUrl = leagueUrl;
    }


    @Override
    public String toString() {
        return "NationalityLeagueName{" +
                "natinalityUrl='" + natinalityUrl + '\'' +
                ", leagueName='" + leagueUrl + '\'' +
                '}';
    }
}
