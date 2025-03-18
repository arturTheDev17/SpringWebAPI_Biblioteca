package com.weg.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Classe que representa um empréstimo de livro e uma entidade deste empréstimo no banco de dados
 * @author arturTheDev17
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    /**
     * ID do emprestimo no banco de dados
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Data de início do emprestimo, do tipo LocalDate, definida automaticamente ao criar o emprestimo
     */
    private LocalDate dataInicioEmprestimo;
    /**
     * Data de prazo de devolucao do emprestimo do tipo LocalDate, que pode ser definida automaticamente ao criar o emprestimo
     */
    private LocalDate dataPrazoDevolucao;
    /**
     * Data de fim do emprestimo, do tipo LocalDate, definida automaticamente ao finalizar o emprestimo
     */
    private LocalDate dataFimEmprestimo;

    /**
     * Multa por atraso do emprestimo, do tipo Double, calculada automaticamente ao finalizar o emprestimo
     */
    private Double multa;

    /**
     * Objeto que representa o Usuario que realizou o emprestimo
     */
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /**
     * Objeto que representa o Livro emprestado
     */
    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

}
