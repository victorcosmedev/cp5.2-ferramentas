package com.br.cp5.mvc_ferramentas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok, @Data cria toda a contrução da classe
@Entity
@Table(name = "TDS_TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String username;
    private String password;
}
