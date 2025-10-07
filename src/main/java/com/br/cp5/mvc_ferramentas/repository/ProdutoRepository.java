package com.br.cp5.mvc_ferramentas.repository;

import com.br.cp5.mvc_ferramentas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);
}
