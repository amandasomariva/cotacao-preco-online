package br.com.amandadev.cotacaoprecoonline.model.cotacao;

import br.com.amandadev.cotacaoprecoonline.model.AbstractEntity;
import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cotacao extends AbstractEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name="produto_id", nullable=false)
    private Produto produto;

    @Column(name = "NOME_FORNECEDOR")
    private String nomeFornecedor;

    @Column(name = "EMAIL_FORNECEDOR")
    private String emailFornecedor;

    @Column(name = "TELEFONE_FORNECEDOR")
    private String telefoneForcenedor;

    public Cotacao() {
    }

    public Cotacao(Produto produto, String nomeFornecedor, String emailFornecedor, String telefoneForcenedor) {
        this.produto = produto;
        this.nomeFornecedor = nomeFornecedor;
        this.emailFornecedor = emailFornecedor;
        this.telefoneForcenedor = telefoneForcenedor;
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

    public String getTelefoneForcenedor() {
        return telefoneForcenedor;
    }

    public void setTelefoneForcenedor(String telefoneForcenedor) {
        this.telefoneForcenedor = telefoneForcenedor;
    }
}
