package com.example.service_adherent.service.level;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelOperationImpl implements LevelOperation{
    private final NoeudRepository noeudRepository;

    /**
     * fonction prenant id dd'un noeud qui est pere calcule et  update le noeud et le
     * compte de l'dherent qui lui est lie
     */

    @Override
    public void reverserBonusParrainnage(String noeud) {

        Noeud parrain = noeudRepository.findByIdNoeud(noeud);

        switch (parrain.getArbre().getNom()){

            case STARTER:
                if (parrain.getBonusP() < 60){
                    parrain.setBonusP(parrain.getBonusP()+30);
                    noeudRepository.save(parrain);
                }
                break;

            case START:
                if (parrain.getBonusP() < 120){
                    parrain.setBonusP(parrain.getBonusP()+60);
                    noeudRepository.save(parrain);
                }

                break;

            case BLUE:
                if (parrain.getBonusP() < 240){
                    parrain.setBonusP(parrain.getBonusP()+120);
                    noeudRepository.save(parrain);
                }
                break;

            case LEADER:
                if (parrain.getBonusP() <480){
                    parrain.setBonusP(parrain.getBonusP()+240);
                    noeudRepository.save(parrain);
                }
                break;


            case COACH:
                if (parrain.getBonusP() < 960){
                    parrain.setBonusP(parrain.getBonusP()+480);
                    noeudRepository.save(parrain);
                }
                break;

            case PLATINIUM:
                if (parrain.getBonusP() < 1920){
                    parrain.setBonusP(parrain.getBonusP()+960);
                    noeudRepository.save(parrain);
                }
                break;

            case DIAMOND:
                if (parrain.getBonusP() <3840){
                    parrain.setBonusP(parrain.getBonusP()+1920);
                    noeudRepository.save(parrain);
                }
                break;

            case SUPER_DIAMOND:
                if (parrain.getBonusP() <7680){
                    parrain.setBonusP(parrain.getBonusP()+3840);
                    noeudRepository.save(parrain);
                }
                break;

            case BOSS:
                if (parrain.getBonusP() <15360){
                    parrain.setBonusP(parrain.getBonusP()+7680);
                    noeudRepository.save(parrain);
                }
                break;

            case SUPER_BOSS:
                if (parrain.getBonusP() <30720){
                    parrain.setBonusP(parrain.getBonusP()+15360);
                    noeudRepository.save(parrain);
                }break;

            default:
        }


    }



    @Override
    public void reverserBonusMat(String noeud) {


    }
}
