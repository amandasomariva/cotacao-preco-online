package br.com.amandadev.cotacaoprecoonline.service.cotacao;

import br.com.amandadev.cotacaoprecoonline.error.ResourceNotFoundException;
import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import br.com.amandadev.cotacaoprecoonline.repository.cotacao.CotacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoService {

    private final CotacaoRepository cotacaoRepository;

    public CotacaoService(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public Iterable<Cotacao> findAll() {
        return this.cotacaoRepository.findAll();
    }

    public Cotacao findById(Long id) {
        Optional<Cotacao> cotacao = this.cotacaoRepository.findById(id);
        if (cotacao.isPresent()) {
            return cotacao.get();
        }
        throw new ResourceNotFoundException("Não existe nenhuma cotacao com esse id" + id);
    }

    public Cotacao save(Cotacao cotacao) {
        return this.cotacaoRepository.save(cotacao);
    }

    public Cotacao update(Cotacao cotacao) {
        return this.cotacaoRepository.save(cotacao);
    }

    public ResponseEntity<Cotacao> deleteById(Long id) {
        boolean cotacaoExiste = this.cotacaoRepository.existsById(id);
        if (cotacaoExiste) {
            this.cotacaoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não existe nenhuma cotação com esse id" + id + "para ser deletado");
    }

    public boolean existeCotacaoProdutoFornecedor(Long id, String email){
        List<Cotacao> cotacoes = this.cotacaoRepository.existeCotacaoProdutoFornecedor(id, email);
        if(cotacoes.isEmpty()){
            return false;
        }
        return true;
    }

}
