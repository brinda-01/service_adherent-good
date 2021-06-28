package com.example.service_adherent.service.noeud;

import com.example.service_adherent.graph_domain.nodes.Noeud;

public interface NoeudService {

    Noeud noeudLevel1(String compte);


    void reverserBonusParrainnage(String noeud);

    Noeud reverserBonusMat(String encetre);
}
