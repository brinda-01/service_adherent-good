package com.example.service_adherent.aop;


import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.service.arbre.ArbreService;
import com.example.service_adherent.service.noeud.NoeudService;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ELAspect {

        private final NoeudService noeudService;
        private final ArbreService arbreService;

    public ELAspect(NoeudService noeudService, ArbreService arbreService) {
        this.noeudService = noeudService;
        this.arbreService = arbreService;
    }


    @AfterReturning(pointcut = "execution(* com.example.service_adherent.service.adherent.AdherentService.addAdherent(..))",returning = "pere")
    public void bonusP(String pere){

        noeudService.reverserBonusParrainnage(pere);
    }

    @AfterReturning(pointcut = "execution(* com.example.service_adherent.service.noeud.NoeudService.reverserBonusParrainnage(..))",returning = "encetre")
    public void bonusMat (String encetre){

        try {
            noeudService.reverserBonusMat(encetre);
        }catch (Exception e){
            System.out.println();
        }

    }

    @AfterReturning(pointcut = "execution(* com.example.service_adherent.service.noeud.NoeudService.reverserBonusMat(..))",returning = "noeud")
    public void switchArbre( Object noeud){

        if (noeud !=null){
            if (noeud instanceof Noeud){
                Noeud next = (Noeud) noeud;
                arbreService.nextArbre(next);
            }
        }



    }








}