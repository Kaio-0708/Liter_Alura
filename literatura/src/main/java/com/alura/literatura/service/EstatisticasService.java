package com.alura.literatura.service;

import com.alura.literatura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatisticasService {

    @Autowired
    private LivroRepository livroRepository;

    public Long contarLivrosPorIdioma(String idioma) {
        return livroRepository.countByIdiomaIgnoreCase(idioma);
    }
}