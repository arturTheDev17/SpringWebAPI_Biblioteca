package com.weg.biblioteca.repository;

import com.weg.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos livros
 */
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
