package com.example.service_adherent.service.token;

import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    private final TokenRepository tokenRepository;
    private final NoeudRepository noeudRepository;


    @Override
    public void saveToken(String toke,String id) {

        VerificationToken token = new VerificationToken();

                    token.setExpirydate(new Date());
                    token.setUser(noeudRepository.findByIdNoeud(id));
                    token.setToken(toke);
                    token.setValable(true);
        tokenRepository.save(token);


    }

    @Override
    public VerificationToken findToken(String token) {
        return tokenRepository.findByToken(token);
    }


}
