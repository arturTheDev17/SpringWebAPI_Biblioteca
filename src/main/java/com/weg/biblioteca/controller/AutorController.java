package com.weg.biblioteca.controller;

import com.weg.biblioteca.model.Autor;
import com.weg.biblioteca.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe de endpoints para manipulação de autores
 * @author arturTheDev17
 */
@AllArgsConstructor
@RestController
@RequestMapping("/autor")
@Tag(name = "Autor", description = "Endpoint para manipulação de autores")
@ApiResponse(responseCode = "400", description = "Requisição inválida")
@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
public class AutorController {
    /**
     * @see AutorService
     */
    private AutorService autorService;

    /**
     * Endpoint para registro de um livro no banco de dados
     * @param autor Objeto do tipo autor
     * @return Objeto do tipo autor com o id gerado automaticamente pelo banco de dados
     */
    @Operation(summary = "Endpoint para registro de um autor no banco de dados", description = "Retorna o autor que foi criado com o ID")
    @ApiResponse(responseCode = "201", description = "Autor criado com sucesso", content = @Content(schema = @Schema(implementation = Autor.class)))
    @PostMapping
    public ResponseEntity<Autor> postAutor( @RequestBody Autor autor ) {
        try {
            return new ResponseEntity<>(autorService.postAutor(autor), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para listagem de todos os autores do banco de dados
     * @return Lista de autores
     */
    @Operation(summary = "Endpoint para listagem de autores no banco de dados", description = "Retorna uma lista de autores")
    @ApiResponse(responseCode = "200", description = "Autores listados com sucesso", content = @Content(schema = @Schema(implementation = Autor.class)))
    @GetMapping
    public ResponseEntity<List<Autor>> getAutores() {
        try {
            return new ResponseEntity<>(autorService.getAutores(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para listagem de um autor especifico do banco de dados a partir do ID
     * @param id ID do autor
     * @return Objeto do tipo autor
     */
    @Operation(summary = "Endpoint para listagem de um autor a partir do id no banco de dados", description = "Retorna um autor")
    @ApiResponse(responseCode = "200", description = "Autor listado com sucesso", content = @Content(schema = @Schema(implementation = Autor.class)))
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(autorService.getAutor(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para exclusão de um autor no banco de dados
     * @param id ID do autor
     * @return Void
     */
    @Operation(summary = "Endpoint para exclusão de um autor no banco de dados", description = "Retorna o autor excluido")
    @ApiResponse(responseCode = "204", description = "Autor excluido com sucesso", content = @Content(schema = @Schema(implementation = Autor.class)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAutor(@PathVariable Integer id) {
        try {
            autorService.removeAutor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para atualização de um autor no banco de dados
     * @param id ID do autor
     * @param autor Objeto do tipo autor
     * @return Objeto do tipo autor
     */
    @Operation(summary = "Endpoint para atualização de um autor no banco de dados", description = "Retorna o autor atualizado")
    @ApiResponse(responseCode = "200", description = "Autor atualizado com sucesso", content = @Content(schema = @Schema(implementation = Autor.class)))
    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        try {
            return new ResponseEntity<>(autorService.updateAutor(id, autor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
