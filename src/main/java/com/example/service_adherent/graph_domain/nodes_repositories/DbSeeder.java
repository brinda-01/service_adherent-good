package com.example.service_adherent.graph_domain.nodes_repositories;


import com.example.service_adherent.graph_domain.enumerations.Level;
import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.graph_domain.nodes.Arbre;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.service.token.TokenRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component

public class DbSeeder implements CommandLineRunner {


    private final ArbreRepository arbreRepository;
    private final NoeudRepository noeudRepository;
    private AdherentRepository adherentRepository;
    private TokenRepository tokenRepository;

    public DbSeeder(ArbreRepository arbreRepository, NoeudRepository noeudRepository, AdherentRepository adherentRepository, TokenRepository tokenRepository) {
        this.arbreRepository = arbreRepository;
        this.noeudRepository = noeudRepository;
        this.adherentRepository = adherentRepository;
        this.tokenRepository = tokenRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //System.out.println(noeudRepository.findByAdherentAndActifIsTrue(adherentRepository.findByCompte("d419d217-5fc7-4edc-9c47-722c32ae6b66")));

        /*Adherent adherent = adherentRepository.findByIdAdherent("4c92c5d9-5d41-4de3-ad14-41b92612e868");
        adherent.setCompte("aa3d3ac9-f153-47fb-ade7-34d66ded0058");
        adherentRepository.save(adherent);*/
        /*Arbre arbre = new Arbre();
        arbre.setNom(Level.SUPER_BOSS);
        arbre.setNiveau(10);
        arbreRepository.save(arbre);*/
        //arbreRepository.deleteById("97097c74-2eab-418c-9533-848a8bc592d4");



        /*Adherent adherent = new Adherent();
        adherent.setCompte("23ede0ac-e38d-4ba1-b28b-41be7df35e14");
        adherent.setPrenom("Sandrine");
        adherent.setNom("HAGBE");

        Noeud noeud = new Noeud();
        noeud.setActif(true);
        noeud.setFull(false);
        noeud.setAdherent(adherentRepository.save(adherent));
        noeud.setPere(null);
        noeud.setArbre(arbreRepository.findByNiveau(1));
        noeudRepository.save(noeud);*/

      // System.out.println(noeudRepository.findByAdherent_IdAdherentAndActifIsTrue(adherentRepository.findByIdAdherent("4c92c5d9-5d41-4de3-ad14-41b92612e868").getIdAdherent()));

       /* Arbre arbre = arbreRepository.findByNiveau(1);
        arbre.setLastInserted("e8138039-2092-4378-9156-df43617aa7eb");
        arbreRepository.save(arbre);*/
       /* Adherent a = adherentRepository.findByCompte("bf6c8b5a-954c-4942-829b-bb830ceeaefa");
        System.out.println(a);
        System.out.println(noeudRepository.findByAdherent_CompteAndActifIsTrue(a.getCompte()));*/


       /* Noeud noeud = new Noeud();
        noeud.setPere(null);
        noeud.setAdherent(adherentRepository.findAll().get(0));
        noeud.setArbre(arbreRepository.findByNiveau(1));
        noeudRepository.save(noeud);
*/









    }

   /* public String parcoursPrefixe(Noeud node) {

        String cle = node.getIdNoeud();
        System.out.println(node);
        if (node.getGauche()!=null){
           // cle = node.getGauche().getIdNoeud();
           // parcoursPrefixe(node.getGauche());
            cle = this.parcoursPrefixe(node.getGauche());

        }

        if (node.getDroit()!=null){
            parcoursPrefixe(node.getDroit());
        }

        return cle;
    }*/
}
