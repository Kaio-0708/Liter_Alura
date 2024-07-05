package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import java.util.List;

public interface AutorService {

    List<Autor> listarTodosAutores();
    List<Autor> findAutoresVivosPorAno(int ano);

}
