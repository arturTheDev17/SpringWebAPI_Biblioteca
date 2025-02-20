package com.weg.biblioteca.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um empréstimo de livro e uma entidade deste empréstimo no banco de dados
 * @author arturTheDev17
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dataInicioEmprestimo;
    private String dataFimEmprestimo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

}
