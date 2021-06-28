package com.example.service_adherent.service.arbre;

import com.example.service_adherent.graph_domain.nodes.Noeud;

public interface ArbreService {

    void nextArbre(Noeud noeud);

    Noeud positionInTree(int arbre);
}
