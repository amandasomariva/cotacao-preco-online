package br.com.amandadev.cotacaoprecoonline.service.cotacao;

import br.com.amandadev.cotacaoprecoonline.error.ResourceNotFoundException;
import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import br.com.amandadev.cotacaoprecoonline.repository.cotacao.CotacaoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CotacaoService {

    private final CotacaoRepository cotacaoRepository;

    public CotacaoService(CotacaoRepository cotacaoRepository) { this.cotacaoRepository = cotacaoRepository; }

    public Iterable<Cotacao> findAll(Pageable pageable){
        return this.cotacaoRepository.findAll(pageable);
    }

    public ResponseEntity<Cotacao> findById(Long id){
        Optional<Cotacao> cotacao = this.cotacaoRepository.findById(id);
        if(cotacao.isPresent()){
            return new ResponseEntity<Cotacao>(cotacao.get(), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não existe nenhuma cotacao com esse id" + id);
    }

    public ResponseEntity<Cotacao> save(Cotacao cotacao){
        return new ResponseEntity<Cotacao>(this.cotacaoRepository.save(cotacao), HttpStatus.CREATED);
    }

    public ResponseEntity<Cotacao> update(Cotacao cotacao){
        return new ResponseEntity<Cotacao>(this.cotacaoRepository.save(cotacao), HttpStatus.OK);
    }

    public ResponseEntity<Cotacao> deleteById(Long id){
        boolean cotacaoExiste = this.cotacaoRepository.existsById(id);
        if(cotacaoExiste){
            this.cotacaoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não existe nenhuma cotação com esse id" + id + "para ser deletado");
    }

}
