package com.example.service_adherent.graph_domain.nodes_repositories;


import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.service.token.TokenRepository;
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

             /*   noeudRepository.deleteById("35aa76b4-88d0-45e7-ab35-0ebeb6a176a0");
                tokenRepository.deleteAll();*/




        /*Noeud noeud = new Noeud();
        noeud.setPere(null);
        noeud.setAdherent(adherentRepository.findAll().get(0));
        noeud.setArbre(arbreRepository.findByNiveau(1));
        noeudRepository.save(noeud);

        noeudRepository.deleteById("01bd279a-3dbe-49f1-a1d5-e35f235954f3");*/








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
