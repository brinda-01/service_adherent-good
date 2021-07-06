package com.example.service_adherent.controllers;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.service.noeud.NoeudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noeud")
@RequiredArgsConstructor
public class NoeudRestController {

    private final NoeudService noeudService;

    @GetMapping("/activeInTree")
    public Noeud activeNodeInTree(@RequestParam("ref") String ref){
        return noeudService.actifNodeInTree(ref);
    }

    @GetMapping("/level1Tree")
    public Noeud level1Tree(@RequestParam("ref") String ref){
        return noeudService.noeudLevel1(ref);
    }


}
