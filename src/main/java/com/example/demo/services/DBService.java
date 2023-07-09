package com.example.demo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Chamado;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Tecnico;
import com.example.demo.domain.enums.Perfil;
import com.example.demo.domain.enums.Prioridade;
import com.example.demo.domain.enums.Status;
import com.example.demo.repositories.ChamadoRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.TecnicoRepository;

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


    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "Michael", "11111111111", "123", "michael@email.com");
        tec1.addPerfil(Perfil.ADMIN);
        
        Cliente cli1 = new Cliente(null, "Silvio", "22222222222", "123", "silvio@email.com");
        
        Chamado c1 = new Chamado(null, Prioridade.MEDIO, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);
        
        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));

    }
}
