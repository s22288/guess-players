package com.example.guessplayerbackend.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player", schema = "guess_player_db", catalog = "")
public class PlayerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "player_id")
    private int playerId;
    @Basic
    @Column(name = "name",unique = true)
    private String name;





    @Basic
    @Column(name = "nationality")
    private String nationality;

    @Basic
    @Column(name = "nationality_url")
    private String nationality_url;


    @Basic
    @Column(name = "value")
    private String value;

    @Basic
    @Column(name = "position")
    private String position;


    @Basic
    @Column(name = "face")
    private String face;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST}
    )
    @JoinTable(
            name = "player_club",
            joinColumns =  @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private Set<ClubEntity> club = new HashSet<>();


    public String getNationality_url() {
        return nationality_url;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void setNationality_url(String nationality_url) {
        this.nationality_url = nationality_url;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public   void addClub ( ClubEntity club){
        this.club.add(club);
        club.getPlayer().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerEntity that = (PlayerEntity) o;

        if (playerId != that.playerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (face != null ? !face.equals(that.face) : that.face != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (face != null ? face.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nationality_url='" + nationality_url + '\'' +
                ", value=" + value +
                ", position='" + position + '\'' +
                ", face='" + face + '\'' +
                '}';
    }
}
