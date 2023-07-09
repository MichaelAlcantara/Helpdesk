package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.demo.domain.enums.Perfil;

//Criar uma tabela
@Entity
public class Cliente extends Pessoa {
    
    private static final long serialVersionUID = 1L;

    //Um para muitos
    // mappedBy = Mapeando ele como tecnico
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

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
