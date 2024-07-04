package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import com.alura.literatura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarTodosAutores() {
        return autorRepository.findAll();
    }

    @Override
    public List<Autor> findAutoresVivosPorAno(int ano) {
        return autorRepository.findByAnoNascimentoLessThanEqualAndAnoMorteGreaterThanEqual(ano, ano);
    }
}