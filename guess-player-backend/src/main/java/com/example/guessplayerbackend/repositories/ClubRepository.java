package com.example.guessplayerbackend.repositories;

import com.example.guessplayerbackend.entity.ClubEntity;
import com.example.guessplayerbackend.entity.LeagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ClubRepository extends JpaRepository<ClubEntity,Integer> {
    @Query("select  n from ClubEntity  n where n.name = :name ")
    Optional<ClubEntity> findClubEntitiesByName(String name);


    @Query(value = "select * from club order by rand() limit 3" , nativeQuery = true)
    List<ClubEntity> findClubEntitiesByName();
//    @Query(value = "select * from club order by rand() limit 3" , nativeQuery = true)
//    List<ClubEntity> findClubEntitiesByName();
    @Query(value = "select * from club c inner  join league l on c.league_league_id = l.league_id  where  l.league_name in ('French Ligue 1','German 1. Bundesliga','English Premier League') order by rand() limit 1",nativeQuery = true)
ClubEntity clubsFromMostFamousLeagues();

}
