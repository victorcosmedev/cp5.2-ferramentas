package com.br.cp5.mvc_ferramentas.controller;

import com.br.cp5.mvc_ferramentas.exception.ProdutoNotFoundException;
import com.br.cp5.mvc_ferramentas.model.Produto;
import com.br.cp5.mvc_ferramentas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public String listaTodosProdutos(Model model){
        model.addAttribute("produtos", produtoService.getAllProdutos());
        return "index";  // sem "templates/"
    }



    @GetMapping("/novo")
    public String adicionarProduto(Model model){
        model.addAttribute("produto", new Produto());
        return "formulario-produto";
    }

    @PostMapping
    public String adicionarProduto(Produto produto){
        produtoService.adicionarProduto(produto);
        return "redirect:/produto";
    }

    @GetMapping("/buscarPorNome")
    public String buscarPorNome(@RequestParam String nome, Model model){
        List<Produto> produto = Collections.singletonList(produtoService.findAllByNome(nome));
        model.addAttribute("produtos", List.of(produto));
        return "index";
    }



    @GetMapping("/editar/{id}")
    public String carregarFormularioEdicao(@PathVariable Long id, Model model) throws ProdutoNotFoundException {
        Produto produto = produtoService.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
        model.addAttribute("produto", produto);
        return "formulario-atualiza";
    }

    @PutMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Produto produto) throws ProdutoNotFoundException {
        produtoService.atualizarProduto(id, produto);
        return "redirect:/produto";
    }

    @DeleteMapping("/{id}")
    public String deletarPorId(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return "redirect:/produto";
    }

}
