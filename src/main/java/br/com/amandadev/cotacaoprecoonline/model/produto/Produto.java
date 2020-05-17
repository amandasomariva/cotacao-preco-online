package br.com.amandadev.cotacaoprecoonline.model.produto;

import br.com.amandadev.cotacaoprecoonline.model.AbstractEntity;
import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Produto extends AbstractEntity {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_INICIAL")
    private LocalDate dataInicial;

    @Column(name = "DATA_FINAL")
    private LocalDate dataFinal;

    @OneToMany(mappedBy="produto")
    @JsonIgnore
    private Set<Cotacao> cotacoes;

    public Produto() {
    }

    public Produto(String nome, LocalDate dataInicial, LocalDate dataFinal) {
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial){
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal(){
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal){
        this.dataFinal = dataFinal;
    }

    public Set<Cotacao> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(Set<Cotacao> cotacoes) {
        this.cotacoes = cotacoes;
    }
}
