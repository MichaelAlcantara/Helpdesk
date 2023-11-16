package com.michael.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.michael.helpdesk.services.DBService;

//uma Classe de configuração
@Configuration
//Perfil de teste
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBService dbService;
    
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;
    
    //Assim que roda esse perfil, o que esta dentro desse método irá subir
    @Bean
    public boolean instanciaDB() {
        if(value.equals("create")) {
        	this.dbService.instanciaDB();
        }
        return false;

    }
}
