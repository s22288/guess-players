package com.example.guessplayerbackend.controller;

import com.example.guessplayerbackend.entity.ClubEntity;
import com.example.guessplayerbackend.service.GamePlayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/public/searchData")
@CrossOrigin(origins = "*")
public class SearchingController {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(SearchingController.class);
   @Autowired
    private GamePlayService gamePlayService;

    public SearchingController(GamePlayService gamePlayService) {
        this.gamePlayService = gamePlayService;
    }

    @GetMapping(value = "/leaguebyid/{id}")
    public ResponseEntity<List<String>> getAllClubs(@PathVariable String id){
        logger.info("id" + id);


        String leageuBaseOnId = gamePlayService.findLeageuBaseOnId(Integer.parseInt(id));

        List<String> data = new ArrayList<>();
        data.add(leageuBaseOnId);
        logger.info("tablica" + data);
        return ResponseEntity.ok(data);
    }
}
