package com.example.service_adherent.service.Prospect;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.mapper.Dtos.ProspectEmailInvitationDto;
import com.example.service_adherent.mapper.Dtos.ProspectWhatsappDto;


public interface ProspectService {

    void parrainerViaMail(ProspectEmailInvitationDto prospectEmailInvitationDto);

    void parrainerViaWhatSapp(ProspectWhatsappDto prospectWhatsappDto);

    Noeud inscription();


}
