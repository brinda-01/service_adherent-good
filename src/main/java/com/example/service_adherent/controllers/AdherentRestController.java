package com.example.service_adherent.controllers;

import com.example.service_adherent.mapper.Dtos.AdherentDto;
import com.example.service_adherent.service.adherent.AdherentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adherent")
public class AdherentRestController {

    private final AdherentService adherentService;

    public AdherentRestController(AdherentService adherentService) {
        this.adherentService = adherentService;
    }

    @PostMapping("/create")
    public ResponseEntity creerAdherent (@RequestBody AdherentDto adherentDto){
        adherentService.addAdherent(adherentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
