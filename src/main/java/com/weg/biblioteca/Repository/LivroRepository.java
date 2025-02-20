package com.weg.biblioteca.Repository;

import com.weg.biblioteca.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos livros
 */
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
