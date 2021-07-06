package com.example.service_adherent.service.token;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Node
@Data
public class VerificationToken {


    @Id @GeneratedValue
    private Long tokenId;

    private String token;

    @Relationship(value = "identifie",direction = Relationship.Direction.INCOMING)
    private Noeud user;

    private Date expirydate;

    private boolean valable;




}
