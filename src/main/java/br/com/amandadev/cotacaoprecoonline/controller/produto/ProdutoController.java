package br.com.amandadev.cotacaoprecoonline.controller.produto;

import br.com.amandadev.cotacaoprecoonline.model.produto.Produto;
import br.com.amandadev.cotacaoprecoonline.service.produto.ProdutoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
            this.service = service;
    }

    @GetMapping
    public Iterable<Produto> findAll(Pageable pageable){
        return this.service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return this.service.save(produto);

    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        return this.service.upDate(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteById(@PathVariable Long id){
        return this.service.deleteById(id);
    }

}
