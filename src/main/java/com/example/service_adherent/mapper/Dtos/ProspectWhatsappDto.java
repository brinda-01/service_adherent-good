package com.example.service_adherent.mapper.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProspectWhatsappDto {

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty(value = "parrain")
    private String parrain;

    @JsonProperty(value = "pere")
    private String pere;
}
