//package com.example.guessplayerbackend;
//
//import com.example.guessplayerbackend.entity.ClubEntity;
//import com.example.guessplayerbackend.entity.LeagueEntity;
//import com.example.guessplayerbackend.entity.PlayerEntity;
//import com.example.guessplayerbackend.repositories.ClubRepository;
//import com.example.guessplayerbackend.repositories.LeagueRepository;
//import com.example.guessplayerbackend.repositories.PlayerRepository;
//import jakarta.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//
//
//@Service
//public class InitMethods {
//
//
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    @Autowired
//    private LeagueRepository leagueRepository;
//
//    @Autowired
//    private ClubRepository clubRepository;
//
//    public InitMethods(ClubRepository clubRepository) {
//        this.clubRepository = clubRepository;
//    }
//
//
//    public InitMethods(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }
//
//    public InitMethods(LeagueRepository leagueRepository) {
//        this.leagueRepository = leagueRepository;
//    }
//
//    public InitMethods() {
//    }
//
//    @PostConstruct
//    public void saveToDb() throws IOException {
//        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/guessplayerbackend/all.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] split = line.split(";");
//                PlayerEntity playerEntity = new PlayerEntity();
//                String name = split[2];
//                ;
//                String value = split[3];
//                String clubName = split[4];
//                String league = split[5];
//                String position = split[6];
//                String nationality = split[11];
//                String face = split[12];
//                String clubLogon = split[13];
//                String nationalLogon = split[14];
//                String natinalFlag = split[15];
//                String national_url = split[16];
//                playerEntity.setName(name);
//                playerEntity.setValue(value);
//                playerEntity.setPosition(position);
//                playerEntity.setNationality(nationality);
//                playerEntity.setFace(face);
//                playerEntity.setNationality_url(national_url);
////                System.out.println(playerEntity);
//                LeagueEntity leagueEntity = new LeagueEntity();
//                leagueEntity.setLeagueName(league);
//                LeagueEntity exists = leagueRepository.findByLeagueName(leagueEntity.getLeagueName()).orElse(null);
//
//                if (exists == null) {
//                    leagueRepository.save(leagueEntity);
//                }  //                    System.out.println(" league exists");
//
//
//                LeagueEntity foundLeague = leagueRepository.findByLeagueNameContains(league).get();
//                int leagueId = foundLeague.getLeagueId();
//                ClubEntity clubEntity = new ClubEntity();
//                clubEntity.setName(clubName);
//                clubEntity.setClubPhoto(clubLogon);
//
//                clubEntity.setLeagueLeagueId(leagueId);
//
//                ClubEntity clubexists = clubRepository.findClubEntitiesByName(clubEntity.getName()).orElse(null);
//                if (clubexists == null) {
//                    clubRepository.save(clubEntity);
//                }  //                    System.out.println(" club exists");
//
//                PlayerEntity playerexists = playerRepository.findPlayerEntitiesBy(playerEntity.getName()).orElse(null);
//                if (playerexists == null) {
//                    playerRepository.save(playerEntity);
//                }
//
//                PlayerEntity playerFound = playerRepository.findPlayerEntitiesBy(playerEntity.getName()).orElse(null);
//                ClubEntity foundClub = clubRepository.findClubEntitiesByName(clubEntity.getName()).orElse(null);
//               playerFound.addClub(foundClub);
//               playerRepository.save(playerFound);
//
//
//
//
//
//
////                playerRepository.save(playerEntity);
//
//
//            }
//        }
//    }
//}
