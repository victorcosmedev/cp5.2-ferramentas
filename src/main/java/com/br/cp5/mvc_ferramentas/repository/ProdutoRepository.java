package com.br.cp5.mvc_ferramentas.repository;

import com.br.cp5.mvc_ferramentas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContaining(String nome);
}
