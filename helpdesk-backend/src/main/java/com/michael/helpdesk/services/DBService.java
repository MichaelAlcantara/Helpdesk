package com.michael.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.michael.helpdesk.domain.Chamado;
import com.michael.helpdesk.domain.Cliente;
import com.michael.helpdesk.domain.Tecnico;
import com.michael.helpdesk.domain.enums.Perfil;
import com.michael.helpdesk.domain.enums.Prioridade;
import com.michael.helpdesk.domain.enums.Status;
import com.michael.helpdesk.repositories.ChamadoRepository;
import com.michael.helpdesk.repositories.ClienteRepository;
import com.michael.helpdesk.repositories.TecnicoRepository;

//Significa que é uma classe de serviços
@Service
public class DBService {
    
    // Faz injeção de dependencias
    @Autowired
    private TecnicoRepository tecnicoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ChamadoRepository chamadoRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;


    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "Mario", "13464457028", encoder.encode("123"), "mario@email.com");
        tec1.addPerfil(Perfil.ADMIN);
        
        Tecnico tec2 = new Tecnico(null, "Fulano", "44629709002", encoder.encode("123"), "Fulano@email.com");
        tec2.addPerfil(Perfil.TECNICO);

        Tecnico tec3 = new Tecnico(null, "Albert", "96921976033", encoder.encode("123"), "Albert@email.com");
        tec2.addPerfil(Perfil.TECNICO);

        Tecnico tec4 = new Tecnico(null, "Franciso", "47709983090", encoder.encode("123"), "Franciso@email.com");
        tec2.addPerfil(Perfil.ADMIN);
        
        Tecnico tec5 = new Tecnico(null, "Juliano", "15537387050", encoder.encode("123"), "Juliano@email.com");
        tec2.addPerfil(Perfil.TECNICO);
        
        Cliente cli1 = new Cliente(null, "Rodolfo", "65305081041", encoder.encode("123"), "rodolfo@email.com");
        
        Cliente cli2 = new Cliente(null, "Enzo", "37307969092", encoder.encode("123"), "Enzo@email.com");
        
        Cliente cli3 = new Cliente(null, "Maria", "91346686084", encoder.encode("123"), "Maria@email.com");
        
        Chamado c1 = new Chamado(null, Prioridade.MEDIO, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);
        
        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
        chamadoRepository.saveAll(Arrays.asList(c1));

    }
}
