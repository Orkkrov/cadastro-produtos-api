package br.com.freedomtecnologia.api.cadastroprodutosapi.model;


import br.com.freedomtecnologia.api.cadastroprodutosapi.enums.Categoria;
import br.com.freedomtecnologia.api.cadastroprodutosapi.enums.Raridade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Column(precision = 10, scale = 2)
    private BigDecimal preco;
    private int quantidade;
    private int estoqueMinimo;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Raridade raridade;

}
