package com.br.cp5.mvc_ferramentas.repository;

import com.br.cp5.mvc_ferramentas.model.Produto;
import com.br.cp5.mvc_ferramentas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
