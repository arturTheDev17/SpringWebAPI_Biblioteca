package com.weg.biblioteca.Repository;

import com.weg.biblioteca.Model.Livro;
import com.weg.biblioteca.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Camada de acesso do banco de dados e das ações relacionadas aos usuarios
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
