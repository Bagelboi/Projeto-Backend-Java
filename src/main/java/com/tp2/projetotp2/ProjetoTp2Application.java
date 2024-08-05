package com.tp2.projetotp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjetoTp2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoTp2Application.class, args);
    }

}
