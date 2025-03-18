package com.weg.biblioteca.repository;

import com.weg.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos usuarios
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
