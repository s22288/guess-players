package com.example.guessplayerbackend.repositories;

import com.example.guessplayerbackend.entity.ClubEntity;
import com.example.guessplayerbackend.entity.LeagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity,Integer> {
@Query("select  n from LeagueEntity  n where n.leagueName = :name ")
Optional <LeagueEntity> findByLeagueName(String name);

    @Query("select  n from LeagueEntity  n where n.leagueName = :name ")
    Optional <LeagueEntity> findByLeagueNameContains(String name);

    @Query(value = "select * from league limit 7" , nativeQuery = true)
    List<LeagueEntity> findRandomLeagues();







}
