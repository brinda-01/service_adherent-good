package com.example.service_adherent.graph_domain.nodes_repositories;


import com.example.service_adherent.graph_domain.nodes.Adherent;
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

        /*Adherent adherent = new Adherent();
        adherent.setCompte("bf6c8b5a-954c-4942-829b-bb830ceeaefa");
        adherent.setPrenom("jasmine");
        adherent.setNom("kuku");

        Noeud noeud = new Noeud();
        noeud.setActif(true);
        noeud.setFull(false);
        noeud.setAdherent(adherentRepository.save(adherent));
        noeud.setPere(null);
        noeud.setArbre(arbreRepository.findByNiveau(1));
        noeudRepository.save(noeud);*/

      // System.out.println(noeudRepository.findByAdherentAndActifIsTrue(adherentRepository.findByCompte("bf6c8b5a-954c-4942-829b-bb830ceeaefa")));

        Adherent a = adherentRepository.findByCompte("bf6c8b5a-954c-4942-829b-bb830ceeaefa");
        System.out.println(a);
        System.out.println(noeudRepository.findByAdherent_CompteAndActifIsTrue(a.getCompte()));


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
