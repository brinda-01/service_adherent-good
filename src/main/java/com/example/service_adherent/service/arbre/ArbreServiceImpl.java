package com.example.service_adherent.service.arbre;

import com.example.service_adherent.graph_domain.nodes.Arbre;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.ArbreRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArbreServiceImpl implements ArbreService{
    private final ArbreRepository arbreRepository;
    private final NoeudRepository noeudRepository;

    @Override
    public void nextArbre(Noeud noeud) {


        switch (noeud.getArbre().getNom()){

            case STARTER:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 300) {












                    /*Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(2));
                    noeudRepository.save(next);

                    Noeud encetre = noeudRepository.findByIdNoeud(arbreRepository.findByNiveau(2).getLastInserted());

                    //on desactive le noeud du niveau precedent
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
*/
                } break;

            case START:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 0){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(3));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);

                }break;

            case  BLUE:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 1){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(4));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }break;


            case LEADER:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 2){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(5));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }break;

            case COACH:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 4){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(6));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }break;

            case PLATINIUM:
                if ((noeud.getBonusMat() + noeud.getBonusP())== 5){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(7));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }break;

            case DIAMOND:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 5){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(8));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }
            case SUPER_DIAMOND:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 90){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(9));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }
            case BOSS:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 45){

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbreRepository.findByNiveau(10));
                    noeudRepository.save(next);
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                }
            case SUPER_BOSS:
            default:

        }

    }

    @Override
    public Noeud positionInTree(int arbre) {

        Arbre tree = arbreRepository.findByNiveau(arbre);


        return null;
    }
}
