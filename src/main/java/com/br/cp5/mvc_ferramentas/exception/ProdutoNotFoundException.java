package com.br.cp5.mvc_ferramentas.exception;

public class ProdutoNotFoundException extends Exception {
    public ProdutoNotFoundException(Long id){
        super("Produto de ID " + id + " não foi encontrado.");
    }
}
