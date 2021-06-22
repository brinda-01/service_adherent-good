package com.example.service_adherent.service.adherent;

import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.graph_domain.nodes.Arbre;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.AdherentRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import com.example.service_adherent.mapper.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdherentServiceImpl implements AdherentService{
    private final NoeudRepository noeudRepository;
    private final MapStructMapper mapper;
    private final AdherentRepository adherentRepository;

    @Override
    public void addAdherent(AdherentDto adherentDto) {

        Noeud noeud = noeudRepository.findByIdNoeud(adherentDto.getIdNoeud());

        noeud.setAdherent(adherentRepository.
                                    save(mapper.
                                            adherentDtoToAdherent(adherentDto)
                                    )
        );

        noeudRepository.save(noeud);



    }

    @Override
    public Adherent searchAdherent(String compte) {
        if (compte.isEmpty()){
            return null;
        }
        return adherentRepository.findByCompte(compte);
        //return null;
    }
}
