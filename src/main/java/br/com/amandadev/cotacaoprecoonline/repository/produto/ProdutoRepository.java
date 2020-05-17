package br.com.amandadev.cotacaoprecoonline.repository.produto;

import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

}
