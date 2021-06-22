package com.example.service_adherent.graph_domain.nodes_repositories;


import com.example.service_adherent.graph_domain.nodes.Adherent;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface AdherentRepository extends Neo4jRepository<Adherent,String> {

    Adherent findByIdAdherent(String id);

    Adherent findByCompte(String compte);




}
