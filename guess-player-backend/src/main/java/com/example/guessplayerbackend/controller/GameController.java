package com.example.guessplayerbackend.controller;

import com.example.guessplayerbackend.entity.ClubEntity;
import com.example.guessplayerbackend.entity.LeagueEntity;
import com.example.guessplayerbackend.entity.PlayerEntity;
import com.example.guessplayerbackend.entity.dto.NationalityLeagueName;
import com.example.guessplayerbackend.repositories.LeagueRepository;
import com.example.guessplayerbackend.repositories.PlayerRepository;
import com.example.guessplayerbackend.service.GamePlayService;
import com.example.guessplayerbackend.entity.dto.LeagueClubObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/football-game")
@CrossOrigin(origins = "*")
public class GameController {
    @Autowired
    private GamePlayService gamePlayService;


    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private LeagueRepository leagueRepository;
    @GetMapping(value = "/hello")
    public ResponseEntity<String> welcomeMapping(){
        return ResponseEntity.ok("welcome");
    }

    public GameController(GamePlayService gamePlayService, PlayerRepository playerRepository, LeagueRepository leagueRepository) {
        this.gamePlayService = gamePlayService;
        this.playerRepository = playerRepository;
        this.leagueRepository = leagueRepository;
    }

    @GetMapping(value = "/clubs")
    public  ResponseEntity<List<ClubEntity>> getAllClubs(){
        List<ClubEntity> allClubs = gamePlayService.getAllClubs();
        return ResponseEntity.ok(allClubs);
    }

    @GetMapping(value = "/leagues")
    public  ResponseEntity<List<LeagueEntity>> getLeagues(){
        List<LeagueEntity> all = leagueRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/players")
    public  ResponseEntity<List<PlayerEntity>> getPlayers(){
        List<PlayerEntity> allPlayers = playerRepository.findAll();
        return  ResponseEntity.ok(allPlayers);
    }

    @GetMapping(value = "/conditions")
    public  ResponseEntity<List<LeagueClubObject>> getConditionWithClubsAndLeagues(){
        List<LeagueClubObject> randomClubsAndLeagues = gamePlayService.get3randomClubsAndLeagues();
        return ResponseEntity.ok(randomClubsAndLeagues);
    }


    @GetMapping(value = "/countires-and-leagues")
    public  ResponseEntity<List<NationalityLeagueName>> getCountriesWithLeagueNames(){
        List<NationalityLeagueName> allContriesAvalible = gamePlayService.getAllContriesAvalible();
        return ResponseEntity.ok(allContriesAvalible);
    }

    @GetMapping(value = "random-club")
    public
    ResponseEntity<ClubEntity> getRandomClubFromfamouseLeague(){
        ClubEntity randomClubFromMostFamousLeagues = gamePlayService.getRandomClubFromMostFamousLeagues();
        return ResponseEntity.ok(randomClubFromMostFamousLeagues);
    }

//    @GetMapping(value = "random-league")
//    public
//    ResponseEntity<List<ClubEntity>> getClubsFromRandomLeague(){
//        LeagueEntity ranomLeague = gamePlayService.getRanomLeague();
//        return ResponseEntity.ok(ranomLeague.get);
//    }
}
