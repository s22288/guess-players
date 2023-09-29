package com.example.guessplayerbackend.repositories;

import com.example.guessplayerbackend.entity.LeagueEntity;
import com.example.guessplayerbackend.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity,Integer> {
    @Query("select  n from PlayerEntity  n where n.name = :name ")
    Optional<PlayerEntity> findPlayerEntitiesBy(String name);


//    @Query("select  n from LeagueEntity  n where n.leagueName = :name ")
//    Optional <LeagueEntity> findByLeagueName(String name);

    @Query(value = " select distinct nationality_url from player where nationality in ('Portugal','France','England','Brazil','Spain','Germany','Poland','Argentina') order by  rand()",nativeQuery = true)
    Optional <List<String>> getAllPlayerCountries();


    @Query(value = " select l.league_name from player p inner join player_club pb on p.player_id = pb.player_id inner join  club c on pb.club_id  = c.club_id inner join league l on c.league_league_id =  l.league_id where p.player_id =:id ",nativeQuery = true)
    String findLeagueNameByplayerid(int id);
}
