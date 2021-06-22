package com.example.service_adherent.graph_domain.nodes;

import com.example.service_adherent.graph_domain.enumerations.Level;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;


@Node("Arbre")
@Data
public class Arbre {

        @Id @GeneratedValue(UUIDStringGenerator.class)
        private String treeId;

        private  int niveau;

        private Level nom;











}
