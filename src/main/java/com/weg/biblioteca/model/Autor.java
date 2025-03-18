package com.weg.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

/**
 * Classe que representa um autor de livros e uma entidade do autor no banco de dados
 * @author arturTheDev17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Autor {
    /**
     * ID do autor do tipo inteiro gerado automaticamente pelo banco de dados
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do autor, do tipo String. Nao pode ser nulo
     */
    @Column(nullable = false)
    private String nome;
    /**
     * Ano de nascimento do autor, do tipo inteiro
     */
    private Integer anoNascimento;
    /**
     * Nacionalidade do autor, do tipo String
     */
    private String nacionalidade;

    /**
     * Lista de livros do autor
     * Conforme as anotações abaixo, é possível remover todos os livros se o seu autor for removido.
     */
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
    private List<Livro> livros;
}
