package com.example.service_adherent.controllers;

import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import com.example.service_adherent.service.adherent.AdherentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/adgerentById/{id}")
    public Adherent searchById(@PathVariable String id){
        return adherentService.adherentById(id);

    }

    @PostMapping("/admin/listAdherent")
    public Page<Adherent> pagesAdherent (@RequestBody Map<String, String> filter,
                                         @RequestParam(value = "numPage",defaultValue = "0") int numPage ,
                                         @RequestParam(value = "taille",defaultValue ="10" ) int taille){
        return adherentService.pagesAdherent(filter, numPage, taille);
    }

    @GetMapping("/searchAdherent")
    public Adherent searchAdherent(@RequestParam String compte){
        return adherentService.searchAdherent(compte);
    }

    @GetMapping("/updateAdherent")
    public Adherent updateCompte(@RequestBody Adherent adherent){

        return adherentService.updateAdherent(adherent);
    }

}
