package com.example.guessplayerbackend.service;

import com.example.guessplayerbackend.entity.ClubEntity;
import com.example.guessplayerbackend.entity.LeagueEntity;
import com.example.guessplayerbackend.entity.dto.NationalityLeagueName;
import com.example.guessplayerbackend.repositories.ClubRepository;
import com.example.guessplayerbackend.repositories.LeagueRepository;
import com.example.guessplayerbackend.repositories.PlayerRepository;
import com.example.guessplayerbackend.entity.dto.LeagueClubObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GamePlayService {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(GamePlayService.class);

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private LeagueRepository leagueRepository;

    public GamePlayService(ClubRepository clubRepository, PlayerRepository playerRepository, LeagueRepository leagueRepository) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
        this.leagueRepository = leagueRepository;
    }

    public List<ClubEntity> getAllClubs() {
        return clubRepository.findAll();
    }

    public List<NationalityLeagueName> getAllContriesAvalible() {
        List<String> countries = playerRepository.getAllPlayerCountries().get();
        List<LeagueEntity> leaguesUrl = leagueRepository.findRandomLeagues();
        Collections.shuffle(leaguesUrl);
        List<NationalityLeagueName> nationalityLeagueNameList = new ArrayList<>();
        if (countries.size() < 3 || leaguesUrl.size()<3) {
            try {
                throw new Exception("not enougth data to play a game");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 3; i++) {
            NationalityLeagueName natinalityleagueObject = new NationalityLeagueName();
            natinalityleagueObject.setNatinalityUrl(countries.get(i));
            natinalityleagueObject.setLeagueUrl(leaguesUrl.get(i).getLeaguePhoto());
            natinalityleagueObject.setLeagueName(leaguesUrl.get(i).getLeagueName());

            nationalityLeagueNameList.add(natinalityleagueObject);

        }
        return nationalityLeagueNameList;
    }

    public List<LeagueClubObject> get3randomClubsAndLeagues() {
        List<LeagueClubObject> leagueClubObjects = new ArrayList<>();
        List<LeagueEntity> byLeagueName = leagueRepository.findRandomLeagues();
        logger.info("before shuffle " + byLeagueName );
        Collections.shuffle(byLeagueName);
        logger.info("after shuffle " + byLeagueName );

        List<ClubEntity> clubEntitiesByName = clubRepository.findClubEntitiesByName();

        for (int i = 0; i < 3; i++) {
            LeagueClubObject temp = new LeagueClubObject();
            temp.setClubEntity(clubEntitiesByName.get(i));
            temp.setLeagueEntity(byLeagueName.get(i));
            leagueClubObjects.add(temp);
        }
        logger.info("objects" + leagueClubObjects);
        return leagueClubObjects;
    }
    public String findLeageuBaseOnId(int id) {
        String leageuName = playerRepository.findLeagueNameByplayerid(id);
        return leageuName;
    }

    public ClubEntity getRandomClubFromMostFamousLeagues(){
    return     clubRepository.clubsFromMostFamousLeagues();
    }

    public  LeagueEntity getRanomLeague(){
        List<LeagueEntity> randomLeagues = leagueRepository.findRandomLeagues();
        Collections.shuffle(randomLeagues);
        return randomLeagues.get(0);
    }
}
