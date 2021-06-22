package com.example.service_adherent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAdherentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAdherentApplication.class, args);
    }

}
