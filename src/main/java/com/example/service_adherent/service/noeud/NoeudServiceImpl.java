package com.example.service_adherent.service.noeud;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.AdherentRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.ArbreRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoeudServiceImpl implements NoeudService{
    private final NoeudRepository noeudRepository;
    private final ArbreRepository arbreRepository;
    private final AdherentRepository adherentRepository;

    /**
     * fonction qui renvoie un adherent dans l'arbre du niveau
     * @Param adherent , celui ci c'est la referrence de ce son compte
     * il provoit du service compte
     */

    @Override
    public Noeud noeudLevel1(String adherent) {

        return noeudRepository.findByAdherentAndArbre(adherentRepository.findByCompte(adherent),
                arbreRepository.findByNiveau(1));
    }
}
