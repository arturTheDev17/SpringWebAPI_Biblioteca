package com.weg.biblioteca.Model;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private Integer anoNascimento;
    private String nacionalidade;


    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Livro> livros;
}
