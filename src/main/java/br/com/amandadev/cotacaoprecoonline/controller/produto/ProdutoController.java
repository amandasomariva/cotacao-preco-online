package br.com.amandadev.cotacaoprecoonline.controller.produto;

import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import br.com.amandadev.cotacaoprecoonline.service.produto.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Produto> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping("/cotacao/{id}")
    public List<Cotacao> findCotacaoByIdProduto(@PathVariable Long id) {
        return this.service.findCotacaoByIdProduto(id);

    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return this.service.save(produto);

    }

    @PutMapping
    public Produto update(@RequestBody Produto produto) {
        return this.service.upDate(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteById(@PathVariable Long id) {
        return this.service.deleteById(id);
    }

    @GetMapping("/cotacao-habilitado")
    public List<Produto> findProdutoHabilitadoCotacao() {
        return this.service.findProdutoHabilitadoCotacao();
    }
}

