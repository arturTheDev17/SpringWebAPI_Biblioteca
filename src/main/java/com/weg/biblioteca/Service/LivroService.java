package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Autor;
import com.weg.biblioteca.Model.Livro;
import com.weg.biblioteca.Repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository livroRepository;
    private AutorService autorService;

    public Livro postLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivro(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> getLivrosByAutor(Integer autorId) {
        return autorService.getAutor(autorId).getLivros();
    }

    public Livro cadastrarAutor(Integer idAutor, Integer idLivro) {
        Livro livro = getLivro(idLivro);
        livro.setAutor(autorService.getAutor(idAutor));
        return postLivro(livro);
    }
}
