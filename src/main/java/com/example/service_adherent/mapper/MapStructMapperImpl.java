package com.example.service_adherent.mapper;


import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;


@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class MapStructMapperImpl implements MapStructMapper{


    @Override
    public Adherent adherentDtoToAdherent(AdherentDto adherentDto) {
        if (adherentDto == null){
            return null;
        }
        Adherent adherent = new Adherent();
        //adherent.setDate_naissance(adherentDto.getDate_naissance());
        adherent.setNom(adherentDto.getNom());
        adherent.setPrenom(adherentDto.getPrenom());
        adherent.setCompte(adherentDto.getCompte());
        return adherent;
    }
}
