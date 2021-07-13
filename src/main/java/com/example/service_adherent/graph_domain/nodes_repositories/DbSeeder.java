package com.example.service_adherent.graph_domain.nodes_repositories;


import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.service.arbre.ArbreService;
import com.example.service_adherent.service.token.TokenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component

public class DbSeeder implements CommandLineRunner {


    private final ArbreRepository arbreRepository;
    private final NoeudRepository noeudRepository;
    private AdherentRepository adherentRepository;
    private TokenRepository tokenRepository;
    private final ArbreService arbreService;

    public DbSeeder(ArbreRepository arbreRepository, NoeudRepository noeudRepository, AdherentRepository adherentRepository, TokenRepository tokenRepository, ArbreService arbreService) {
        this.arbreRepository = arbreRepository;
        this.noeudRepository = noeudRepository;
        this.adherentRepository = adherentRepository;
        this.tokenRepository = tokenRepository;
        this.arbreService = arbreService;
    }


    @Override
    public void run(String... args) throws Exception {
        //System.out.println(noeudRepository.findByAdherentAndActifIsTrue(adherentRepository.findByCompte("d419d217-5fc7-4edc-9c47-722c32ae6b66")));

        /*Arbre arbre = new Arbre();
        arbre.setNiveau(3);
        arbre.setNom(Level.BLUE);
        arbreRepository.save(arbre);
        Arbre a = arbreRepository.findByNiveau(1);
        a.setLastInserted("187bd903-bfc2-426d-aeae-bbb73b6a9750");
        arbreRepository.save(a);*/
        Noeud noeud = noeudRepository.findByIdNoeud("a7d09761-030f-418d-a657-a9af67eecd49");

           arbreService.nextArbre(noeud);
        arbreService.positionInTree(2);
        /*Adherent adherent = new Adherent();
        adherent.setCompte("aa3d3ac9-f153-47fb-ade7-34d66ded0058");
        adherent.setPrenom("Sandrine");
        adherent.setNom("HAGBE");


        Noeud noeud = new Noeud();
        noeud.setActif(true);
        noeud.setFull(false);
        noeud.setAdherent(adherentRepository.save(adherent));
        noeud.setPere(null);
        noeud.setArbre(arbreRepository.findByNiveau(1));
        noeudRepository.save(noeud);*/

      // System.out.println(noeudRepository.findByAdherentAndActifIsTrue(adherentRepository.findByCompte("bf6c8b5a-954c-4942-829b-bb830ceeaefa")));


        //System.out.println(noeudRepository.findByAdherent_CompteAndActifIsTrue(a.getCompte()));


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
