package com.alura.literatura.controller;

import com.alura.literatura.model.Autor;
import com.alura.literatura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    public void listarTodosAutores() {
        List<Autor> autores = autorService.listarTodosAutores();
        autores.forEach(autor -> {
            System.out.println("Nome: " + autor.getNome() +
                    ", Ano de Nascimento: " + autor.getAnoNascimento() +
                    ", Ano de Falecimento: " + (autor.getAnoMorte() != null ? autor.getAnoMorte() : "Vivo"));
        });
    }

    public void listarAutoresVivosNoAno(int ano) {
        List<Autor> autores = autorService.findAutoresVivosPorAno(ano);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor vivo encontrado no ano de " + ano);
        } else {
            autores.forEach(autor -> {
                System.out.println("Nome: " + autor.getNome() +
                        ", Ano de Nascimento: " + autor.getAnoNascimento() +
                        ", Ano de Falecimento: " + (autor.getAnoMorte() != null ? autor.getAnoMorte() : "Vivo"));
            });
        }
    }
}