package com.weg.biblioteca.Controller;

import com.weg.biblioteca.Model.Livro;
import com.weg.biblioteca.Service.LivroService;
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

@RestController
@AllArgsConstructor
@RequestMapping("/livro")
@Tag(name = "Livro", description = "Endpoint para manipulação de livros")
@ApiResponse(responseCode = "400", description = "Requisição inválida")
@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
public class LivroController {

    private LivroService livroService;

    /**
     * Endpoint para registro de um livro no banco de dados
     * @param livro Objeto do tipo livro
     * @return Livro: Objeto do tipo livro
     */
    @Operation(summary = "Endpoint para registro de um livro no banco de dados", description = "Retorna o livro que foi criado com o ID")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @PostMapping
    public ResponseEntity<Livro> postLivro(@RequestBody Livro livro) {
        try {
            return new ResponseEntity<>( livroService.postLivro( livro ) , HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de todos os livros do banco de dados
     * @return List<Livro>: Lista de livros
     */
    @Operation(summary = "Endpoint para listagem de livros no banco de dados", description = "Retorna uma lista de livros")
    @ApiResponse(responseCode = "200", description = "Livros listados com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @GetMapping
    public ResponseEntity<List<Livro>> getLivros() {
        try {
            return new ResponseEntity<>( livroService.getLivros() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de um livro especifico do banco de dados a partir do ID
     * @param id ID do livro
     * @return Livro: Objeto do tipo livro
     *
     */
    @Operation(summary = "Endpoint para listagem de livro a partir do id no banco de dados", description = "Retorna um livro")
    @ApiResponse(responseCode = "200", description = "Livro listado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivro(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( livroService.getLivro( id ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de livros a partir de um autor no banco de dados
     * @param id ID do autor
     * @return List<Livro>: Lista de livros
     */
    @Operation(summary = "Endpoint para listagem de livros a partir de um autor no banco de dados", description = "Retorna uma lista de livros")
    @ApiResponse(responseCode = "200", description = "Livros do autor listados com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @GetMapping("/autor/{id}")
    public ResponseEntity<List<Livro>> getLivrosByAutor(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( livroService.getLivrosByAutor( id ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para exclusão de um livro no banco de dados
     * @param id ID do livro
     * @return Void
     */
    @Operation(summary = "Endpoint para exclusão de um livro no banco de dados", description = "Retorna o livro excluido")
    @ApiResponse(responseCode = "204", description = "Livro excluido com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeLivro(@PathVariable Integer id) {
        try {
            livroService.removeLivro(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para atualização de um livro no banco de dados
     * @param id ID do livro
     * @param livro Objeto do tipo livro
     * @return Livro: Objeto do tipo livro
     */
    @Operation(summary = "Endpoint para atualização de um livro no banco de dados", description = "Retorna o livro atualizado")
    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        try {
            return new ResponseEntity<>(livroService.updateLivro(id, livro), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
