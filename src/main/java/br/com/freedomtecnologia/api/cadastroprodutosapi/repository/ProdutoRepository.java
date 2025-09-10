package br.com.freedomtecnologia.api.cadastroprodutosapi.repository;

import br.com.freedomtecnologia.api.cadastroprodutosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
