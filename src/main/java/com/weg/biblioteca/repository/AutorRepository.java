package com.weg.biblioteca.repository;

import com.weg.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos autores
 */
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
