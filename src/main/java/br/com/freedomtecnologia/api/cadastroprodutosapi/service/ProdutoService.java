package br.com.freedomtecnologia.api.cadastroprodutosapi.service;


import br.com.freedomtecnologia.api.cadastroprodutosapi.controller.ProdutoController;
import br.com.freedomtecnologia.api.cadastroprodutosapi.enums.Categoria;
import br.com.freedomtecnologia.api.cadastroprodutosapi.enums.Raridade;
import br.com.freedomtecnologia.api.cadastroprodutosapi.exception.NomePequenoException;
import br.com.freedomtecnologia.api.cadastroprodutosapi.model.Produto;
import br.com.freedomtecnologia.api.cadastroprodutosapi.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto) {
        if (produto.getDescricao().length() < 3)
            throw new NomePequenoException("produto deve ter mais de 3 caracteres");
        if (produto.getPreco().doubleValue() < 0) throw new RuntimeException("preço negativo");
        if (produto.getQuantidade() < 0) throw new RuntimeException("quantidade negativa");

        int tipoProduto = (produto.getPreco().doubleValue() > 20) ? 1 : 2;

        switch (tipoProduto) {
            case 1:
                produto.setRaridade(Raridade.RARO);
                produto.setCategoria(Categoria.PRODUZIDO);
                break;
            case 2:
                produto.setRaridade(Raridade.COMUM);
                produto.setCategoria(Categoria.FABRICADO);
                break;
            default:
                produto.setRaridade(Raridade.COMUM);
                produto.setCategoria(Categoria.FABRICADO);

        }
        LocalDate data  = LocalDate.now();
        produto.setDataCadastro(Date.valueOf(data));

        return this.produtoRepository.save(produto);
    }

    public List<Produto> retornaProdutos() {
        return this.produtoRepository.findAll();
    }

    public Optional<Produto> retornaProdutoPeloId(Long id) {
        Optional<Produto> p = this.produtoRepository.findById(id);

        return p;
    }
    
    
    public void deletaProdutos(){
        this.produtoRepository.deleteAll();
    }


    public void deletaProdutoPeloId(Long id){
        this.produtoRepository.deleteById(id);
    }
}
