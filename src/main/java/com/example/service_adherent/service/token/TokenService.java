package com.example.service_adherent.service.token;

public interface TokenService {

    void saveToken(String toke, String id);

    VerificationToken findToken(String token);
}
