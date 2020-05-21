package br.com.amandadev.cotacaoprecoonline.repository.cotacao;


import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CotacaoRepository extends PagingAndSortingRepository<Cotacao, Long> {

    @Query("select c from Cotacao c where c.emailFornecedor = ?2 and c.produto.id = ?1")
    List<Cotacao> existeCotacaoProdutoFornecedor(Long id, String email);
}