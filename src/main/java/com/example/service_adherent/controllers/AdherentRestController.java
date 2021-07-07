package com.example.service_adherent.controllers;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import com.example.service_adherent.service.adherent.AdherentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adherent")
public class AdherentRestController {

    private final AdherentService adherentService;

    public AdherentRestController(AdherentService adherentService) { this.adherentService = adherentService; }

    @PostMapping("/create")
    public ResponseEntity creerAdherent (@RequestBody AdherentDto adherentDto){
        adherentService.addAdherent(adherentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }




}
