package com.weg.biblioteca.repository;

import com.weg.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos emprestimos
 */
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
