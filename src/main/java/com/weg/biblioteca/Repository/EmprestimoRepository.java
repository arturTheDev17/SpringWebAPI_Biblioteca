package com.weg.biblioteca.Repository;

import com.weg.biblioteca.Model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos emprestimos
 */
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
