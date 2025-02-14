package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Autor;
import com.weg.biblioteca.Repository.AutorRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Operações, lógica de negócios e comunicação com o banco de dados relacionadas aos autores
 */
@Service
@AllArgsConstructor
@Tag(name = "Autor" , description = "Operações, lógica de negócios e comunicação com o banco de dados relacionadas aos autores")
public class AutorService {

    /**
     * @see AutorRepository
     */
    private AutorRepository autorRepository;

    /**
     * Insere um autor no banco de dados
     * @param autor Objeto do tipo autor
     * @return Autor: Objeto do tipo autor com o id gerado automaticamente pelo banco de dados
     */
    public Autor postAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Retorna uma lista de autores do banco de dados
     * @return List<Autor>: Lista de autores
     */
    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    /**
     * Retorna um autor do banco de dados a partir do id
     * @param id ID do autor
     * @return Autor: Objeto do tipo autor, referente ao id informado
     */
    public Autor getAutor(Integer id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }
}
