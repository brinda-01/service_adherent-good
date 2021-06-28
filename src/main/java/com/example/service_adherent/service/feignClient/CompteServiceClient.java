package com.example.service_adherent.service.feignClient;

import com.example.service_adherent.mapper.Dtos.CompteOfAdherent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "compte-service")
public interface CompteServiceClient {

        @GetMapping("/compte/compteOfAdherent")
         CompteOfAdherent obtainAdherent(@RequestParam("ref") String ref);

        @PutMapping("/compte/updateSolde")
        void updateSolde(@RequestParam("compte") String compte, @RequestParam("solde") int solde);
}
