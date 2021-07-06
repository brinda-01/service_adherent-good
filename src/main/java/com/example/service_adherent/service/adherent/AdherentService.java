package com.example.service_adherent.service.adherent;

import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import com.example.service_adherent.mapper.pages.Pageable;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface AdherentService {

    String addAdherent(AdherentDto adherentDto);

    Adherent searchAdherent(String compte);

    Page<Adherent> pagesAdherent(Map<String,String> filter, int numPage, int taille);

    Adherent updateAdherent(Adherent adherent);

    Adherent adherentById(String id);


}
