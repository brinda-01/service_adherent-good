package com.example.service_adherent.aop;

import com.example.service_adherent.service.level.LevelOperation;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EasyLifeAspect {

    private LevelOperation levelOperation;

    public EasyLifeAspect(LevelOperation levelOperation) {
        this.levelOperation = levelOperation;
    }


    @Pointcut("execution(* com.example.service_adherent.service.adherent.AdherentService.addAdherent(..))")
    private void addAdherent(){}

    @AfterReturning(value = "addAdherent()",returning ="pere" )
    public void afterAddAdherent(String pere){

        if (pere.isEmpty()) throw new RuntimeException("pere absent");
        levelOperation.reverserBonusParrainnage(pere);

    }
}
