package com.michael.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michael.helpdesk.domain.dtos.ClienteDTO;
import com.michael.helpdesk.domain.dtos.TecnicoDTO;
import com.michael.helpdesk.domain.enums.Perfil;

//Criar uma tabela
@Entity
public class Cliente extends Pessoa {
    
    private static final long serialVersionUID = 1L;

    //Um para muitos
    // mappedBy = Mapeando ele como tecnico
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String senha, String email) {
        super(id, nome, cpf, senha, email);
        addPerfil(Perfil.CLIENTE);
    }
    
    public Cliente(ClienteDTO obj) {
    	super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.senha = obj.getSenha();
		this.email = obj.getEmail();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
