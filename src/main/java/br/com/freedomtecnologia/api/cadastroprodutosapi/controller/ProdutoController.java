package br.com.freedomtecnologia.api.cadastroprodutosapi.controller;


import br.com.freedomtecnologia.api.cadastroprodutosapi.model.Produto;
import br.com.freedomtecnologia.api.cadastroprodutosapi.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping("/produto")
    public Produto cadastraProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping("/produto")
    public List<Produto> retornaProdutos() {
        return produtoService.retornaProdutos();
    }

    @GetMapping("/produto/{id}")
    public Optional<Produto> retornaProdutoPeloId(@PathVariable Long id) {
        return produtoService.retornaProdutoPeloId(id);
    }

    @DeleteMapping("/produto")
    public void deletaProdutos() {
        produtoService.deletaProdutos();
    }

    @DeleteMapping("/produto/{id}")
    public void deletaProdutoPeloId(@PathVariable Long id) {
        produtoService.deletaProdutoPeloId(id);
    }


    @PutMapping("/produto/{id}/atualizar")
    public Produto atualizaProduto(@RequestBody Produto produto, @PathVariable Long id){

        produto.setPreco(BigDecimal.ZERO);


        return produtoService.retornaProdutoPeloId(id)
                .map(p -> {
                    p.setNome(produto.getNome());
                    p.setDescricao(produto.getDescricao());
                    return produtoService.salvarProduto(produto);
                })
                .orElseGet(() -> {
                    return produtoService.salvarProduto(produto);
                });
    }



}
