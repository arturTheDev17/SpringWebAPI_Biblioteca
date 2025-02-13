package com.weg.biblioteca.Repository;

import com.weg.biblioteca.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
