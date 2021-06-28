package com.example.service_adherent.aop;


import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.service.noeud.NoeudService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class aspect {

        private NoeudService noeudService;

    public aspect(NoeudService noeudService) {
        this.noeudService = noeudService;
    }


    @Pointcut("execution(* com.example.service_adherent.service.adherent.AdherentService.addAdherent(..))")
    private void addAdherent(){}

    @AfterReturning(value = "addAdherent()", returning = "pere")
    public void afterAddAdherentBonusParrainage(String pere){

        if (pere.isEmpty()) throw new RuntimeException("pere absent");
        noeudService.reverserBonusParrainnage(pere);

    }

    @AfterReturning(value = "addAdherent()",returning = "pere")
    public Noeud afterAddAdherentBonusMatriciel(String pere){
         return noeudService.reverserBonusMat(pere);

    }


}