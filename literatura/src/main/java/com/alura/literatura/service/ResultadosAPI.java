package com.alura.literatura.service;

import com.alura.literatura.model.Livro;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ResultadosAPI {

    @JsonProperty("count")
    private int contagem;

    @JsonProperty("results")
    private List<Livro> resultados;

    public int getContagem() {
        return contagem;
    }

    public void setContagem(int contagem) {
        this.contagem = contagem;
    }

    public List<Livro> getResultados() {
        if (resultados == null) {
            resultados = new ArrayList<>();
        }
        return resultados;
    }

    public void setResultados(List<Livro> resultados) {
        this.resultados = resultados;
    }
}