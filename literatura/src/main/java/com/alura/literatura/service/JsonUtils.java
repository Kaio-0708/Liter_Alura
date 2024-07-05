package com.alura.literatura.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JsonUtils {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<LivroJson> converterJsonParaListaLivros(String json) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, LivroJson.class));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para lista de LivroJson", e);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LivroJson {
        @JsonAlias({"title", "titulo"})
        private String titulo;

        private List<AutorJson> authors;

        @JsonAlias({"languages", "idioma"})
        private String idioma;

        @JsonAlias({"download_count", "numeroDownloads"})
        private int numeroDownloads;

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return authors != null ? authors.stream().map(AutorJson::getName).collect(Collectors.joining(", ")) : "";
        }

        public void setAuthors(List<AutorJson> authors) {
            this.authors = authors;
        }

        public String getIdioma() {
            return idioma;
        }

        public void setIdioma(String idioma) {
            this.idioma = idioma;
        }

        public int getNumeroDownloads() {
            return numeroDownloads;
        }

        public void setNumeroDownloads(int numeroDownloads) {
            this.numeroDownloads = numeroDownloads;
        }

        @Override
        public String toString() {
            return "LivroJson{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + getAutor() + '\'' +
                    ", idioma='" + idioma + '\'' +
                    ", numeroDownloads=" + numeroDownloads +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AutorJson {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "AutorJson{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public LivroJson converterJsonParaLivro(String json) {
        try {
            return objectMapper.readValue(json, LivroJson.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para objeto LivroJson", e);
        }
    }
}
