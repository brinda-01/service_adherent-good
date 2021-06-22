package com.example.service_adherent.service.token;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TokenRepository extends Neo4jRepository<VerificationToken , Long> {

    VerificationToken findByToken(String token);
}
