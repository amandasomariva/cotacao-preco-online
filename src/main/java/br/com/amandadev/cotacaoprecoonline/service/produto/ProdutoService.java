package br.com.amandadev.cotacaoprecoonline.service.produto;

import br.com.amandadev.cotacaoprecoonline.error.ResourceNotFoundException;
import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import br.com.amandadev.cotacaoprecoonline.repository.produto.ProdutoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Iterable<Produto> findAll(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    public ResponseEntity<Produto> findById(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if(produto.isPresent()){
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não existe nenhum produto com esse id" + id);
    }

    public ResponseEntity<Produto> save(Produto produto) {
        return new ResponseEntity<Produto>(this.produtoRepository.save(produto), HttpStatus.CREATED);
    }

    public ResponseEntity<Produto> upDate(Produto produto){
        return new ResponseEntity<Produto>(this.produtoRepository.save(produto), HttpStatus.OK);
    }

    public ResponseEntity<Produto> deleteById(Long id){
        boolean produtoExiste = this.produtoRepository.existsById(id);
        if (produtoExiste) {
                this.produtoRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            throw new ResourceNotFoundException("Não existe nenhum produto com esse id" + id + "para ser deletado");
    }
}