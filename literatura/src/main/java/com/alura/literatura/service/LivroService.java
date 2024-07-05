package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Livro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ConsumoApi consumoApi;

    @Autowired
    private ConverteDados converteDados;

    @Transactional(readOnly = true)
    public Livro buscarLivroPorTitulo(String titulo) {

            List<Livro> livros = livroRepository.findByTituloIgnoreCaseContaining(titulo);
            if (livros != null && !livros.isEmpty()) {
                return livros.get(0);
            }

            List<Livro> livrosAPI = converteDados.converterLivros(consumoApi.buscarLivroPorTitulo(titulo));
            if (livrosAPI != null && !livrosAPI.isEmpty()) {
                return livrosAPI.get(0);
            }

            return null;
        }

    @Transactional(readOnly = true)
    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Livro> buscarPorIdioma(String idioma) {
        return livroRepository.findByIdiomaIgnoreCase(idioma);
    }

    @Transactional(readOnly = true)
    public List<Autor> listarTodosAutores() {
        return autorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Autor> findAutoresVivosPorAno(int ano) {
        return autorRepository.findByAnoNascimentoLessThanEqualAndAnoMorteGreaterThanEqual(ano, ano);
    }

}
