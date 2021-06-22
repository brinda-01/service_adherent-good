package com.example.service_adherent.mapper.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProspectEmailInvitationDto {

    @JsonProperty("email")
    private String email;

    @JsonProperty(value = "pere")
    private String pere;

}
