package com.alura.literatura.service;

import com.alura.literatura.model.Livro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ConverteDados implements IConverteDados {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException {
        return objectMapper.readValue(json, classe);
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) throws JsonProcessingException {
        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, classe));
    }

    public List<Livro> converterLivros(Map<String, Object> dados) {
        List<Livro> livros = new ArrayList<>();
        List<Map<String, Object>> resultados = (List<Map<String, Object>>) dados.get("results");

        for (Map<String, Object> resultado : resultados) {
            Livro livro = new Livro();
            livro.setTitulo((String) resultado.get("title"));
            livro.setIdioma(parseIdiomas(resultado.get("languages")));
            livro.setNumeroDownloads(parseInteger(resultado.get("download_count")));
            livros.add(livro);
        }
        return livros;
    }

    private String parseIdiomas(Object languages) {
        if (languages instanceof List) {
            List<String> idiomas = (List<String>) languages;
            return String.join(", ", idiomas);
        } else if (languages instanceof String) {
            return (String) languages;
        }
        return null;
    }

    private int parseInteger(Object value) {
        if (value instanceof Integer) {
            return (int) value;
        } else if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }
}
