package com.example.service_adherent.service.tasks;

import com.example.service_adherent.service.token.TokenRepository;
import com.example.service_adherent.service.token.VerificationToken;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableAsync
@EnableScheduling
public class EasyLifeTask {

    private final TokenRepository tokenRepository;

    public EasyLifeTask(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }


    @Scheduled(cron = "@midnight")
    public void desactiverToken(){
        List<VerificationToken> tokens = tokenRepository.findByValableIsTrue();

        for (VerificationToken token:tokens
             ) {
            token.setValable(false);
            tokenRepository.save(token);
        }
    }


    public void deleteToken(){
     List<VerificationToken> tokens = tokenRepository.findByValableIsFalse();
     for (VerificationToken token : tokens){
         tokenRepository.deleteById(token.getTokenId());
     }
    }

}
