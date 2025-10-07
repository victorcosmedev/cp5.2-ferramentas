package com.br.cp5.mvc_ferramentas.repository;

import com.br.cp5.mvc_ferramentas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
