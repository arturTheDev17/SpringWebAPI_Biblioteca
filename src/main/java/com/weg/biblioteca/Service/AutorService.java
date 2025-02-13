package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Autor;
import com.weg.biblioteca.Repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutorService {
    private AutorRepository autorRepository;

    public Autor postAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutor(Integer id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }
}
