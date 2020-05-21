package br.com.amandadev.cotacaoprecoonline.controller.cotacao;

import br.com.amandadev.cotacaoprecoonline.model.cotacao.Cotacao;
import br.com.amandadev.cotacaoprecoonline.service.cotacao.CotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    private final CotacaoService service;

    public CotacaoController(CotacaoService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Cotacao> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Cotacao findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Cotacao save(@RequestBody Cotacao cotacao) {
        return this.service.save(cotacao);
    }

    @PutMapping
    public Cotacao update(@RequestBody Cotacao cotacao) {
        return this.service.update(cotacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cotacao> deleteById(@PathVariable Long id) {
        return this.service.deleteById(id);
    }

    @GetMapping("/{idProduto}/{emailFornecedor}")
    public boolean existeCotacaoProdutoFornecedor(@PathVariable Long idProduto, @PathVariable  String emailFornecedor){
        return this.service.existeCotacaoProdutoFornecedor(idProduto, emailFornecedor);

    }
}
