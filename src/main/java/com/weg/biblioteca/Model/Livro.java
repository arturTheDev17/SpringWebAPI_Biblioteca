package com.weg.biblioteca.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String genero;
    private Integer anoPublicacao;

    @ManyToOne
    private Autor autor;

    @OneToOne( mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private Emprestimo emprestimo;

}
