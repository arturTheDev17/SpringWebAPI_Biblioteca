package com.weg.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um livro e uma entidade livro do banco de dados
 * @author arturTheDev17
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    /**
     * ID de tipo inteiro do livro, gerado automaticamente pelo banco de dados
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Titulo do livro, armazenado em uma string
     */
    private String titulo;
    /**
     * Genero do livro, armazenado em uma string
     */
    private String genero;
    /**
     * Ano de publicacao do livro, armazenado em um inteiro
     */
    private Integer anoPublicacao;

    /**
     * Variavel que armazena o objeto que representa o autor do livro, referente ao ID do autor no banco de dados.
     * Conforme as anotações abaixo, é possível criar um livro juntamente com seu autor.
     * Além disso, o livro deve obrigatoriamente ter um autor
     */
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Autor autor;

    /**
     * Variavel que armazena o objeto que representa o emprestimo do livro, referente ao ID do emprestimo no banco de dados.
     * Conforme as anotações abaixo, é possível criar, editar e remover um livro juntamente com seu emprestimo.
     */
    @OneToOne( mappedBy = "livro", cascade = CascadeType.ALL)
    private Emprestimo emprestimo;

}
