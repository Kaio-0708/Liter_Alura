package com.alura.literatura.controller;

import com.alura.literatura.service.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    @Autowired
    private EstatisticasService estatisticasService;

    @GetMapping("/contarLivrosPorIdioma/{idioma}")
    public ResponseEntity<Long> contarLivrosPorIdioma(@PathVariable String idioma) {
        List<String> idiomasSuportados = Arrays.asList("es", "en", "fr", "pt");
        if (!idiomasSuportados.contains(idioma)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Long count = estatisticasService.contarLivrosPorIdioma(idioma);
        if (count == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(count);
    }
}