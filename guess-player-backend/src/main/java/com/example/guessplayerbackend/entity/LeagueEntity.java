package com.example.guessplayerbackend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "league", schema = "guess_player_db", catalog = "")
public class LeagueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "league_id")
    private int leagueId;
    @Basic
    @Column(name = "league_name" , unique = true)
    private String leagueName;
    @Basic
    @Column(name = "league_photo",length = 2000)



    private String leaguePhoto;

    public LeagueEntity() {
    }

    public LeagueEntity(int leagueId, String leagueName, String leaguePhoto) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.leaguePhoto = leaguePhoto;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeaguePhoto() {
        return leaguePhoto;
    }

    public void setLeaguePhoto(String leaguePhoto) {
        this.leaguePhoto = leaguePhoto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueEntity that = (LeagueEntity) o;

        if (leagueId != that.leagueId) return false;
        if (!Objects.equals(leagueName, that.leagueName)) return false;
        return Objects.equals(leaguePhoto, that.leaguePhoto);
    }

    @Override
    public int hashCode() {
        int result = leagueId;
        result = 31 * result + (leagueName != null ? leagueName.hashCode() : 0);
        result = 31 * result + (leaguePhoto != null ? leaguePhoto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LeagueEntity{" +
                "leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", leaguePhoto='" + leaguePhoto + '\'' +
                '}';
    }
}
