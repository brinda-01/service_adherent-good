package com.example.service_adherent.graph_domain.nodes;


import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node("Noeud")
@Data
public class Noeud {

    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String idNoeud;

    @Relationship(value = "nee_a_gauche",direction = Relationship.Direction.INCOMING)
    private Noeud gauche;

    @Relationship(value = "nee_a_droite",direction = Relationship.Direction.INCOMING)
    private Noeud droit;

    private String pere;

    private String frere;

    private boolean Full;

    @Relationship(value = "se_situe",direction = Relationship.Direction.OUTGOING)
    private Arbre arbre ;

    @Relationship(value = "represente",direction = Relationship.Direction.OUTGOING)
    private Adherent adherent;

    private Boolean actif;

    private int bonusP=0;

    private int bonusMat =0;






}
