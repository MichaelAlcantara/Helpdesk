package com.michael.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.michael.helpdesk.domain.enums.Perfil;

//Criar uma tabela
@Entity
public abstract class Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //Ele será reconhecido como um ID no banco
    @Id
    //Irá criar automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    
    //Significa que essa coluna será única
    @Column(unique = true)
    @CPF
    protected String cpf;
    protected String senha;
    
    //Significa que essa coluna será única
    @Column(unique = true)
    protected String email;
    
    //É um coleção de Integer, tem que vim junto com o usuario
    @ElementCollection(fetch = FetchType.EAGER)
    //Irá criar uma tabela de PERFIS
    @CollectionTable(name = "PERFIS")
    protected Set<Integer> perfis = new HashSet<>();
    
    //Criar um padrão de data
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public Pessoa() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String nome, String cpf, String senha, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        addPerfil(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
    }

}
