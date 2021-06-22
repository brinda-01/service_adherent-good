package com.example.service_adherent.graph_domain.nodes;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Node("Adherent")
@Data
public class Adherent {

    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String idAdherent;

    private String nom;

    private String prenom;

    /*@DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date date_naissance;*/

    private String compte;



}
