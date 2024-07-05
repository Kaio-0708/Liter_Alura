package com.alura.literatura.principal;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Livro;
import com.alura.literatura.service.AutorService;
import com.alura.literatura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LivroService livroService;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        exibeMenu();
    }

    public void exibeMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = -1;

            while (opcao != 0) {
                System.out.println("1. Buscar livro pelo título");
                System.out.println("2. Listar todos os livros");
                System.out.println("3. Listar todos os autores");
                System.out.println("4. Listar autores vivos em um determinado ano");
                System.out.println("5. Listar livros por idioma");

                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            buscarLivroPorTitulo();
                            break;
                        case 2:
                            listarTodosLivros();
                            break;
                        case 3:
                            listarTodosAutores();
                            break;
                        case 4:
                            listarAutoresVivosPorAno();
                            break;
                        case 5:
                            listarLivrosPorIdioma();
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.nextLine();
                }
            }
        }  catch (Exception e) {
                System.out.println("Ocorreu um erro ao executar a aplicação: " + e.getMessage());
            }
        }

    private void buscarLivroPorTitulo() {
        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine().toLowerCase().trim();
        Livro livro = livroService.buscarLivroPorTitulo(titulo);
        if (livro != null) {
            System.out.println("Livro encontrado:");
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void listarTodosLivros() {
        List<Livro> livros = livroService.buscarTodos();
        if (!livros.isEmpty()) {
            System.out.println("Lista de todos os livros:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    private void listarTodosAutores() {
        List<Autor> autores = autorService.listarTodosAutores();
        if (!autores.isEmpty()) {
            System.out.println("Lista de todos os autores:");
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } else {
            System.out.println("Nenhum autor encontrado.");
        }
    }

    private void listarAutoresVivosPorAno() {
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        List<Autor> autores = autorService.findAutoresVivosPorAno(ano);
        if (!autores.isEmpty()) {
            System.out.println("Lista de autores vivos em " + ano + ":");
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } else {
            System.out.println("Nenhum autor vivo encontrado em " + ano + ".");
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.print("Digite o idioma (es, en, fr, pt): ");
        String idioma = scanner.nextLine().toLowerCase().trim();
        List<Livro> livros = livroService.buscarPorIdioma(idioma);
        if (!livros.isEmpty()) {
            System.out.println("Lista de livros em " + idioma + ":");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        } else {
            System.out.println("Nenhum livro encontrado para o idioma " + idioma + ".");
        }
    }
}
