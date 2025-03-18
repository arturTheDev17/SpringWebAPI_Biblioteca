package com.weg.biblioteca.controller;

import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.service.UsuarioService;
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
 * Classe de endpoints para manipulação de contas de usuários
 * @author arturTheDev17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Endpoint para manipulação de contas de usuários")
@ApiResponse(responseCode = "400", description = "Requisição inválida")
@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
public class UsuarioController {

    /**
     * @see UsuarioService
     */
    private UsuarioService usuarioService;

    /**
     * Endpoint para registro de um usuario no banco de dados
     * @param usuario Objeto do tipo usuario
     * @return Objeto do tipo usuario
     */
    @Operation(summary = "Endpoint para registro de um usuario no banco de dados", description = "Retorna o usuario que foi criado com o ID")
    @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso", content = @Content(schema = @Schema(implementation = Usuario.class)))
    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
        try {
            return new ResponseEntity<>( usuarioService.postUsuario( usuario ) , HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de todos os usuarios do banco de dados
     * @return Lista de usuarios
     */
    @Operation(summary = "Endpoint para listagem de usuarios no banco de dados", description = "Retorna uma lista de usuarios")
    @ApiResponse(responseCode = "200", description = "Usuarios listados com sucesso", content = @Content(schema = @Schema(implementation = Usuario.class)))
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        try {
            return new ResponseEntity<>( usuarioService.getUsuarios() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de um usuario especifico do banco de dados a partir do ID
     * @param id ID do usuario
     * @return Objeto do tipo usuario
     */
    @Operation(summary = "Endpoint para listagem de usuario a partir do id no banco de dados", description = "Retorna um usuario")
    @ApiResponse(responseCode = "200", description = "Usuario listado com sucesso", content = @Content(schema = @Schema(implementation = Usuario.class)))
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( usuarioService.getUsuario( id ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para exclusão de um usuario no banco de dados
     * @param id ID do usuario
     * @return Void
     */
    @Operation(summary = "Endpoint para exclusão de um usuario no banco de dados", description = "Retorna o usuario excluido")
    @ApiResponse(responseCode = "204", description = "Usuario excluido com sucesso", content = @Content(schema = @Schema(implementation = Usuario.class)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUsuario(@PathVariable Integer id) {
        try {
            usuarioService.removeUsuario(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para atualização de um usuario no banco de dados
     * @param id ID do usuario
     * @param usuario Objeto do tipo usuario
     * @return Objeto do tipo usuario
     */
    @Operation(summary = "Endpoint para atualização de um usuario no banco de dados", description = "Retorna o usuario atualizado")
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso", content = @Content(schema = @Schema(implementation = Usuario.class)))
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        try {
            return new ResponseEntity<>(usuarioService.updateUsuario(id, usuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
