package com.example.service_adherent.service;

import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TreeConstructionImpl implements TreeConsctruction{

    private final NoeudRepository noeudRepository;


        int i=0;
        @Getter
    List<String> tas = new ArrayList<>();

    @Override
    public String parcoursPrefixe(Noeud node) {
        //la cle a retourne
       /// String cle = node.getIdNoeud();

       //this.tas.add(cle);


        if (node.getGauche()!=null){

            System.out.println(node);
            //cle = this.parcoursPrefixe(node.getGauche());
            String c = this.parcoursPrefixe(node.getGauche());
            ;





        }

        if (node.getDroit()!=null){
            System.out.println(node);
           // cle = this.parcoursPrefixe(node.getDroit());
            this.parcoursPrefixe(node.getDroit());




        }


        return null;
    }

}
