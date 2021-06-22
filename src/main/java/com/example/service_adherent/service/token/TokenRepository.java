package com.example.service_adherent.service.token;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface TokenRepository extends Neo4jRepository<VerificationToken , Long> {

    VerificationToken findByToken(String token);

    List<VerificationToken> findByValableIsTrue();

    List<VerificationToken> findByValableIsFalse();
}
