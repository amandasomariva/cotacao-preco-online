package br.com.amandadev.cotacaoprecoonline.repository.produto;

import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

    @Query("select c from Cotacao c where c.produto.id = ?1")
    List<Cotacao> findCotacaoByProdutoId(Long produtoId);

}
