package com.example.service_adherent.graph_domain.nodes_repositories;


import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.graph_domain.nodes.Arbre;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface NoeudRepository extends Neo4jRepository<Noeud,String> {

        Noeud findByIdNoeud(String id);

        //Noeud findByAdherentAndArbre(Adherent adherent, Arbre arbre);

        Noeud findByAdherent_CompteAndArbre_Niveau(String adherent,int arbre);

        Noeud findByAdherent_CompteAndActifIsTrue(String compte);

        List<Noeud> findByPere(String pere);








}
