package com.weg.biblioteca.model;

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
    /**
     * ID do usuario, gerado automaticamente pelo banco de dados
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Nome do usuario, do tipo String
     */
    private String nome;
    /**
     * Email do usuario, do tipo String
     */
    private String email;
    /**
     * Senha do usuario, do tipo String
     */
    private String senha;

    /**
     * Objeto que representa um empréstimo de livro feito pelo usuario, qualquer atualizacao no usuario pode modificar o empréstimo também
     */
    @OneToOne( mappedBy = "usuario", cascade = CascadeType.ALL)
    private Emprestimo emprestimo;

}
