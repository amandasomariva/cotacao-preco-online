package br.com.amandadev.cotacaoprecoonline.repository.cotacao;


import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CotacaoRepository extends PagingAndSortingRepository<Cotacao, Long> {

}