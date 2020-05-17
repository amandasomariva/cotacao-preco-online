package br.com.amandadev.cotacaoprecoonline.model.fornecedor;

import br.com.amandadev.cotacaoprecoonline.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends AbstractEntity {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;


    public Fornecedor(){
    }

    public Fornecedor(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

}
