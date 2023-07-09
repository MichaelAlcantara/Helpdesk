package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String senha, String email) {
        super(id, nome, cpf, senha, email);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
