package com.br.cp5.mvc_ferramentas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombock, @Data cria toda a contrução da classe
@Entity
@Table(name = "TDS_TB_FERRAMENTAS")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String classificacao;
    private double tamanho;
    private double preco;
}