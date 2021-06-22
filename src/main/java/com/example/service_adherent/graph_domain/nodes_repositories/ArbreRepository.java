package com.example.service_adherent.graph_domain.nodes_repositories;

import com.example.service_adherent.graph_domain.nodes.Arbre;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ArbreRepository extends Neo4jRepository<Arbre,String> {

    Arbre findByNiveau(int niveau);
}
