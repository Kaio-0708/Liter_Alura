package com.alura.literatura.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ConsumoApi {

    private final String BASE_URL = "https://gutendex.com/books/";

    public Map<String, Object> buscarLivroPorTitulo(String titulo) {
        String url = BASE_URL + "?search=" + titulo.replaceAll("\\s+", "+");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> buscarTop10LivrosMaisBaixados() {
        String url = BASE_URL + "?sort=downloads";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Map.class);
    }
}
