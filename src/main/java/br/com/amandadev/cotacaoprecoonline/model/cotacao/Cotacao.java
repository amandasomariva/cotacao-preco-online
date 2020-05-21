package br.com.amandadev.cotacaoprecoonline.model.cotacao;

import br.com.amandadev.cotacaoprecoonline.model.AbstractEntity;
import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Cotacao extends AbstractEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(name = "NOME_FORNECEDOR")
    private String nomeFornecedor;

    @Column(name = "EMAIL_FORNECEDOR")
    private String emailFornecedor;

    @Column(name = "TELEFONE_FORNECEDOR")
    private String telefoneFornecedor;

    @Column(name = "VALOR")
    private double valor;

    public Cotacao() {
    }

    public Cotacao(Produto produto, String nomeFornecedor, String emailFornecedor, String telefoneFornecedor, double valor) {
        this.produto = produto;
        this.nomeFornecedor = nomeFornecedor;
        this.emailFornecedor = emailFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

