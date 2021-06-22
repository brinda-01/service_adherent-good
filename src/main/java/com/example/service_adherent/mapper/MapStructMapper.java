package com.example.service_adherent.mapper;

import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Adherent adherentDtoToAdherent(AdherentDto adherentDto);



}
