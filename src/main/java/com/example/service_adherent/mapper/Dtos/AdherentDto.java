package com.example.service_adherent.mapper.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AdherentDto {

    @JsonProperty(value = "nom")
    private String nom;

    @JsonProperty(value = "prenom")
    private String prenom;

    /*@JsonProperty(value = "naissance")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date date_naissance;*/

    @JsonProperty(value = "idnoeud")
    private String idNoeud;

    @JsonProperty(value = "compte")
    private String compte;
}
