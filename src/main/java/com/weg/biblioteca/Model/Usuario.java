package com.weg.biblioteca.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um usuario e uma entidade usuário do banco de dados
 * @author arturTheDev17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    @OneToOne( mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Emprestimo emprestimo;

}
