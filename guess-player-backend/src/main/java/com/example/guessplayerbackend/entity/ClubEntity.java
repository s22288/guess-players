package com.example.guessplayerbackend.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "club", schema = "guess_player_db", catalog = "")
public class ClubEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "club_id")
    private int clubId;
    @Basic
    @Column(name = "name" ,unique = true)
    private String name;
    @Basic
    @Column(name = "club_photo")
    private String clubPhoto;
    @Basic
    @Column(name = "League_league_id")
    private int leagueLeagueId;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "club")

    private Set<PlayerEntity> player = new HashSet<>();

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubPhoto() {
        return clubPhoto;
    }

    public void setClubPhoto(String clubPhoto) {
        this.clubPhoto = clubPhoto;
    }

    public int getLeagueLeagueId() {
        return leagueLeagueId;
    }

    public void setLeagueLeagueId(int leagueLeagueId) {
        this.leagueLeagueId = leagueLeagueId;
    }

    public void setPlayer(Set<PlayerEntity> player) {
        this.player = player;
    }

    public Set<PlayerEntity> getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubEntity that = (ClubEntity) o;

        if (clubId != that.clubId) return false;
        if (leagueLeagueId != that.leagueLeagueId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (clubPhoto != null ? !clubPhoto.equals(that.clubPhoto) : that.clubPhoto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clubId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (clubPhoto != null ? clubPhoto.hashCode() : 0);
        result = 31 * result + leagueLeagueId;
        return result;
    }

    @Override
    public String toString() {
        return "ClubEntity{" +
                "clubId=" + clubId +
                ", name='" + name + '\'' +
                ", clubPhoto='" + clubPhoto + '\'' +
                ", leagueLeagueId=" + leagueLeagueId +
                ", player=" + player +
                '}';
    }
}
