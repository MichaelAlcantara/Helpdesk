package com.michael.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.michael.helpdesk.services.DBService;

//uma Classe de configuração
@Configuration
//Perfil de teste
@Profile("test")
public class TesteConfig {
    
    @Autowired
    private DBService dbService;
    
    //Assim que roda esse perfil, o que esta dentro desse método irá subir
    @Bean
    public void instanciaDB() {
        this.dbService.instanciaDB();

    }
}
