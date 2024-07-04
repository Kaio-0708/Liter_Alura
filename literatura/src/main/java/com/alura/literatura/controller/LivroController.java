package com.alura.literatura.controller;

import com.alura.literatura.model.Livro;
import com.alura.literatura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/todos")
    public ResponseEntity<List<Livro>> listarTodosLivros() {
        List<Livro> livros = livroService.buscarTodos();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/idioma/{idioma}")
    public ResponseEntity<List<Livro>> listarLivrosPorIdioma(@PathVariable String idioma) {
        List<Livro> livros = livroService.buscarPorIdioma(idioma);
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Livro> buscarLivroPorTitulo(@PathVariable String titulo) {
        Livro livro = livroService.buscarLivroPorTitulo(titulo);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}