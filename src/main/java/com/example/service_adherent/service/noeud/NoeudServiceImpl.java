package com.example.service_adherent.service.noeud;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.AdherentRepository;

import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoeudServiceImpl implements NoeudService{
    private final NoeudRepository noeudRepository;
  //  private final ArbreRepository arbreRepository;
    private final AdherentRepository adherentRepository;
    //private final CompteServiceClient compteServiceClient;

    /**
     * fonction qui renvoie un adherent dans l'arbre du niveau
     * adherent , celui ci c'est la referrence de ce son compte
     * il provoit du service compte
     */

    @Override
    public Noeud noeudLevel1(String adherent, int arbre) {

        return noeudRepository.findByAdherent_CompteAndArbre_Niveau(
                adherentRepository.findByCompte(adherent).getCompte(),arbre);
    }

    @Override
    public Noeud actifNodeInTree(String compte) {
        return noeudRepository.findByAdherent_CompteAndActifIsTrue(adherentRepository.
                findByCompte(compte).getCompte());
        //return null;
    }


    @Override
    public String reverserBonusParrainnage(String noeud) {
        Noeud parrain = noeudRepository.findByIdNoeud(noeud);

        switch (parrain.getArbre().getNom()){

            case STARTER:
                if (parrain.getBonusP() < 60){
                    parrain.setBonusP(parrain.getBonusP()+30);
                    return noeudRepository.save(parrain).getPere();
                   // compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());

                }
                break;

            case START:
                if (parrain.getBonusP() < 120){
                    parrain.setBonusP(parrain.getBonusP()+60);
                    return noeudRepository.save(parrain).getPere();
                    //compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());

                }

                break;

            case BLUE:
                if (parrain.getBonusP() < 240){
                    parrain.setBonusP(parrain.getBonusP()+120);
                    return noeudRepository.save(parrain).getPere();
                    //compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());

                }
                break;

            case LEADER:
                if (parrain.getBonusP() <480){
                    parrain.setBonusP(parrain.getBonusP()+240);
                   return noeudRepository.save(parrain).getPere();
                   // compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());

                }
                break;


            case COACH:
                if (parrain.getBonusP() < 960){
                    parrain.setBonusP(parrain.getBonusP()+480);
                    return noeudRepository.save(parrain).getPere();
                   // compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());

                }
                break;

            case PLATINIUM:
                if (parrain.getBonusP() < 1920){
                    parrain.setBonusP(parrain.getBonusP()+960);
                    return noeudRepository.save(parrain).getPere();
                    //compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());

                }
                break;

            case DIAMOND:
                if (parrain.getBonusP() <3840){
                    parrain.setBonusP(parrain.getBonusP()+1920);
                    return noeudRepository.save(parrain).getPere();
                }
                break;

            case SUPER_DIAMOND:
                if (parrain.getBonusP() <7680){
                    parrain.setBonusP(parrain.getBonusP()+3840);
                    return noeudRepository.save(parrain).getPere();
                }
                break;

            case BOSS:
                if (parrain.getBonusP() <15360){
                    parrain.setBonusP(parrain.getBonusP()+7680);
                     return noeudRepository.save(parrain).getPere();
                    //compteServiceClient.updateSolde(compte.getAdherent().getCompte(),compte.getBonusP());
                }
                break;

            case SUPER_BOSS:
                if (parrain.getBonusP() <30720){
                    parrain.setBonusP(parrain.getBonusP()+15360);
                    return noeudRepository.save(parrain).getPere();

                }break;

            default:

        }
        return null;
    }

    @Override
    public Noeud reverserBonusMat(String encetre) {

        Noeud grandPere = noeudRepository.findByIdNoeud(encetre);
        List<Noeud> descandants = noeudRepository.findByPere(encetre);

        if (descandants.size() == 2 && grandPere.isActif() &&
                ( (descandants.get(0).getGauche() !=null && descandants.get(0).getDroit() !=null) &&
                        (descandants.get(1).getGauche() != null && descandants.get(1).getDroit() !=null))){

                    switch (grandPere.getArbre().getNom()){

                        case STARTER:
                            grandPere.setBonusMat(240);
                           return noeudRepository.save(grandPere);

                        case START:
                            grandPere.setBonusMat(480);
                            return noeudRepository.save(grandPere);

                        case BLUE:
                            grandPere.setBonusMat(960);
                            return noeudRepository.save(grandPere);

                        case LEADER:
                            grandPere.setBonusMat(1920);
                            return noeudRepository.save(grandPere);

                        case COACH:
                            grandPere.setBonusMat(3840);
                            return noeudRepository.save(grandPere);

                        case PLATINIUM:
                            grandPere.setBonusMat(7680);
                            return noeudRepository.save(grandPere);

                        case DIAMOND:
                            grandPere.setBonusMat(15360);
                            return noeudRepository.save(grandPere);

                        case SUPER_DIAMOND:
                            grandPere.setBonusMat(30720);
                            return noeudRepository.save(grandPere);

                        case BOSS:
                            grandPere.setBonusMat(61440);
                            return noeudRepository.save(grandPere);

                        case SUPER_BOSS:
                            grandPere.setBonusMat(122880);
                            return noeudRepository.save(grandPere);

                        default:
                    }

        }

        return null;
    }
}
