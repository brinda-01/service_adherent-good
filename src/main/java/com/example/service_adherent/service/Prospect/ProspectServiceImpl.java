package com.example.service_adherent.service.Prospect;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.ArbreRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import com.example.service_adherent.mapper.Dtos.ProspectEmailInvitationDto;
import com.example.service_adherent.mapper.Dtos.ProspectWhatsappDto;
import com.example.service_adherent.service.email.EmailService;
import com.example.service_adherent.service.token.TokenService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProspectServiceImpl implements ProspectService {

    private final NoeudRepository noeudRepository;
    private final TokenService tokenService;
    private final EmailService emailService;
    private final ArbreRepository arbreRepository;


    /**
     * fonction permettant de parrainer un prospect et d'envoyer un email a ce dernier
     * @Param ProspectEmailInvitationDto
     */


    @Override
    public void parrainerViaMail(ProspectEmailInvitationDto prospectEmailInvitationDto) {

        //le prospect a parrainer
        Noeud fileul = new Noeud();

        //le token qui permettant d'invalider le mail
        String token = UUID.randomUUID().toString();

        //definition du futur pere sous qui le fileul devra etre insere
        Noeud pere = noeudRepository.findByIdNoeud(prospectEmailInvitationDto.getPere());

        //affectation du pere au fileul
        fileul.setPere(pere.getIdNoeud());

        //fixation dans l'arbre du niveau 1
        fileul.setArbre(arbreRepository.findByNiveau(1));

        //enregistrement et rattachament au pere
            if (pere.getGauche() ==null){
                //definition du fils gauche
                pere.setGauche(noeudRepository.save(fileul));
                //mise a jour du pere
                noeudRepository.save(pere);

                //sauvegarde du token
                tokenService.saveToken(token,noeudRepository.findByIdNoeud(prospectEmailInvitationDto.getPere()).getGauche().getIdNoeud());

                //envoie du mail
            } else {

                //definition du fils droit
                pere.setDroit(noeudRepository.save(fileul));
                //mise a jour du pere
                noeudRepository.save(pere);

                //sauvegarde du token
                tokenService.saveToken(token,noeudRepository.findByIdNoeud(prospectEmailInvitationDto.getPere()).getDroit().getIdNoeud());

                //envoie du mail

            }
        emailService.sendParrainageLink(prospectEmailInvitationDto.getEmail(),token);


    }

    @Override
    public void parrainerViaWhatSapp(ProspectWhatsappDto prospectWhatsappDto) {

    }

    @Override
    public Noeud inscription() {
        return null;
    }


}
