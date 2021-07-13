package com.example.service_adherent.service.arbre;

import com.example.service_adherent.graph_domain.nodes.Arbre;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.ArbreRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import com.example.service_adherent.service.feignClient.CompteServiceClient;
import com.example.service_adherent.service.noeud.NoeudService;
import lombok.RequiredArgsConstructor;
import org.apache.http.util.TextUtils;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArbreServiceImpl implements ArbreService {
    private final ArbreRepository arbreRepository;
    private final NoeudRepository noeudRepository;
    private final CompteServiceClient compteServiceClient;
    private final NoeudService noeudService;


    @Override
    public void nextArbre(Noeud noeud) {


        switch (noeud.getArbre().getNom()) {

            case STARTER:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 300) {

                    Arbre arbre = arbreRepository.findByNiveau(2);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),100);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",200);
                           noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());



                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),100);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",200);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),100);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",200);
                   // noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                }
                break;

            case START:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 600) {

                    Arbre arbre = arbreRepository.findByNiveau(3);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),200);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",400);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),200);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",400);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),200);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",400);

                }
                break;

            case BLUE:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 1200) {

                    Arbre arbre = arbreRepository.findByNiveau(4);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());


                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),400);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",800);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),400);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",800);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),400);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",800);
                }
                break;


            case LEADER:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 2400) {

                    Arbre arbre = arbreRepository.findByNiveau(5);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),800);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",1600);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),800);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",1600);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),800);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",1600);
                }
                break;

            case COACH:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 4800) {

                    Arbre arbre = arbreRepository.findByNiveau(6);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),1600);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",3200);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),1600);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",3200);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),1600);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",3200);
                }
                break;

            case PLATINIUM:
                if ((noeud.getBonusMat() + noeud.getBonusP()) == 9600) {

                    Arbre arbre = arbreRepository.findByNiveau(7);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),3200);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",6400);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),3200);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",6400);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),3200);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",6400);
                }
                break;

            case DIAMOND:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 19200) {

                    Arbre arbre = arbreRepository.findByNiveau(8);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),6400);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",12800);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),6400);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",12800);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),6400);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",12800);

                }
                break;
            case SUPER_DIAMOND:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 38400) {

                    Arbre arbre = arbreRepository.findByNiveau(9);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),12800);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",25600);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),12800);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",25600);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),12800);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",25600);
                }
                break;
            case BOSS:
                if ((noeud.getBonusP() + noeud.getBonusMat()) == 76800) {

                    Arbre arbre = arbreRepository.findByNiveau(10);

                    Noeud next = new Noeud();
                    next.setAdherent(noeud.getAdherent());
                    next.setActif(true);
                    next.setArbre(arbre);

                    Noeud levelParain = positionInTree(arbre.getNiveau());

                    if (levelParain !=null){
                        if (levelParain.getGauche() == null){

                            String last = noeudRepository.save(next).getIdNoeud();
                            arbre.setLastInserted(last);

                            noeud.setActif(false);
                            noeudRepository.save(noeud);
                            levelParain.setGauche(noeudRepository.findByIdNoeud(last));
                            arbreRepository.save(arbre);

                            compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),25600);
                            compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",51200);
                            noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());


                        }
                        String last = noeudRepository.save(next).getIdNoeud();
                        arbre.setLastInserted(last);

                        noeud.setActif(false);
                        noeudRepository.save(noeud);
                        levelParain.setDroit(noeudRepository.findByIdNoeud(last));
                        arbreRepository.save(arbre);

                        compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),25600);
                        compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",51200);
                        noeudService.reverserBonusParrainnage( noeudRepository.save(levelParain).getIdNoeud());

                    }
                    arbre.setLastInserted(noeudRepository.save(next).getIdNoeud());
                    noeud.setActif(false);
                    noeudRepository.save(noeud);
                    arbreRepository.save(arbre);
                    compteServiceClient.updateSolde(noeud.getAdherent().getCompte(),25600);
                    compteServiceClient.updateSolde("e0174d50-3fa1-448e-972b-0c7c0c4a3ff0",51200);
                }
                break;
            case SUPER_BOSS:

                // code a ecrire si l'on est deja au niveau 10
            default:

        }

    }
    /**
     * recuperation de l'arbre demande en BD qui permettra de savoir qui est le dernier adherent inserer dans cette arbre
     * puis selon different scenario on pourra retourner la position ideal a l'insertion dans l'arbre
     */
    @Override
    public Noeud positionInTree(int arbre) {


        /*
        recuperation de l'arbre en base de donnees puis interrogation de celui-ci sur 'attribribut
        -lastInserted
         */
        Arbre tree = arbreRepository.findByNiveau(arbre);

        /*
         * CAS No1 : le champ lastInserted est vide: l'arbre est vide
         * alors on return null
         */
        System.out.println(tree);
        if (TextUtils.isEmpty(tree.getLastInserted())){
             return null;
        }

        //On commence par extraire le noeud qui a ete insere en dernier dans l'arbre
        Noeud last = noeudRepository.findByIdNoeud(tree.getLastInserted());


        /*Cas No2-1 le dernier a entrer dans larbre n'a pas de pere : il est la racine
                Dans ce cas on retourne last
        */
            if (TextUtils.isEmpty(last.getPere())){
                return last;
            }
            Noeud pere = noeudRepository.findByIdNoeud(last.getPere());
            if (!pere.isFull()){
                return pere;
            }
            if (pere.isFull()){
                if (TextUtils.isEmpty(pere.getFrere())){
                    return pere.getGauche();
                }
                Noeud frere = noeudRepository.findByIdNoeud(pere.getFrere());
                    if (!frere.isFull()){
                        return frere;
                    }
                        return noeudRepository.findByIdNoeud(pere.getPere()).getGauche().getGauche();

            }

            return null;
    }
}