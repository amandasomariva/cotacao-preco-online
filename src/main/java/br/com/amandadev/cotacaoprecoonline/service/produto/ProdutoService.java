package br.com.amandadev.cotacaoprecoonline.service.produto;

import br.com.amandadev.cotacaoprecoonline.error.ResourceNotFoundException;
import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import br.com.amandadev.cotacaoprecoonline.repository.produto.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Iterable<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }
        throw new ResourceNotFoundException("Não existe nenhum produto com esse id" + id);
    }

    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public Produto upDate(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public ResponseEntity<Produto> deleteById(Long id) {
        boolean produtoExiste = this.produtoRepository.existsById(id);
        if (produtoExiste) {
            this.produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não existe nenhum produto com esse id" + id + "para ser deletado");
    }

    public List<Cotacao> findCotacaoByIdProduto(Long id) {
        return this.produtoRepository.findCotacaoByProdutoId(id);
    }

    public List<Produto> findProdutoHabilitadoCotacao() {
        return this.produtoRepository.findProdutoHabilitacaoCotacao(LocalDate.now());
    }
}
