package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Livro;
import com.weg.biblioteca.Repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Operações, lógica de negócios e comunicação com o banco de dados relacionadas aos livros
 */
@Service
@AllArgsConstructor
public class LivroService {
    /**
     * @see LivroRepository
     */
    private LivroRepository livroRepository;
    /**
     * @see AutorService
     */
    private AutorService autorService;
    /**
     * Insere um livro no banco de dados
     * @param livro Objeto do tipo livro
     * @return Objeto do tipo livro com o id gerado automaticamente pelo banco de dados
     */
    public Livro postLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    /**
     * Retorna uma lista de livros do banco de dados
     * @return Lista de livros
     */
    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    /**
     * Retorna um livro do banco de dados a partir do id
     * @param id ID do livro
     * @return Objeto do tipo livro
     */
    public Livro getLivro(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    /**
     * Retorna uma lista de livros a partir de um autor no banco de dados
     * @param autorId ID do autor
     * @return Lista de livros
     */
    public List<Livro> getLivrosByAutor(Integer autorId) {
        return autorService.getAutor(autorId).getLivros();
    }

    /**
     * Exclui um livro do banco de dados
     * @param id ID do livro
     */
    public void removeLivro(Integer id) {
        livroRepository.deleteById(id);
    }

    /**
     * Atualiza um livro no banco de dados a partir do id
     * @param id ID do livro
     * @param livro Objeto do tipo livro
     * @return Objeto do tipo livro
     */
    public Livro updateLivro(Integer id, Livro livro) {
        livro.setId(id);
        return livroRepository.save(livro);
    }
}
