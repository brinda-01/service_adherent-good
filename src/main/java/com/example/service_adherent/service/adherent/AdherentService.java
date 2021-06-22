package com.example.service_adherent.service.adherent;

import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.mapper.Dtos.AdherentDto;

public interface AdherentService {

    void addAdherent(AdherentDto adherentDto);

    Adherent searchAdherent(String compte);


}
