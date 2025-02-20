package com.weg.biblioteca.Controller;


import com.weg.biblioteca.Model.Emprestimo;
import com.weg.biblioteca.Service.EmprestimoService;
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
@RequestMapping("/emprestimo")
@AllArgsConstructor
@Tag(name = "Empréstimo", description = "Endpoint para manipulação de empréstimos de livros")
@ApiResponse(responseCode = "400", description = "Requisição inválida")
@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
public class EmprestimoController {

    /**
     * @see EmprestimoService
     */
    private EmprestimoService emprestimoService;

    /**
     * Endpoint para registro de um emprestimo no banco de dados
     * @param emprestimo Objeto do tipo emprestimo
     * @return Objeto do tipo emprestimo
     */
    @Operation(summary = "Endpoint para registro de um emprestimo no banco de dados", description = "Retorna o emprestimo que foi criado com o ID")
    @ApiResponse(responseCode = "201", description = "Emprestimo criado com sucesso", content = @Content(schema = @Schema(implementation = Emprestimo.class)))
    @PostMapping
    public ResponseEntity<Emprestimo> postEmprestimo(@RequestBody Emprestimo emprestimo) {
        try {
            return new ResponseEntity<>( emprestimoService.criarEmprestimo( emprestimo ) , HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de todos os emprestimos do banco de dados
     * @return Lista de emprestimos
     */
    @Operation(summary = "Endpoint para listagem de emprestimos no banco de dados", description = "Retorna uma lista de emprestimos")
    @ApiResponse(responseCode = "200", description = "Emprestimos listados com sucesso", content = @Content(schema = @Schema(implementation = Emprestimo.class)))
    @GetMapping
    public ResponseEntity<List<Emprestimo>> getEmprestimos() {
        try {
            return new ResponseEntity<>( emprestimoService.getEmprestimos() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para listagem de um emprestimo especifico do banco de dados a partir do ID
     * @param id ID do emprestimo
     * @return Objeto do tipo emprestimo
     */
    @Operation(summary = "Endpoint para listagem de emprestimo a partir do id no banco de dados", description = "Retorna um emprestimo")
    @ApiResponse(responseCode = "200", description = "Emprestimo listado com sucesso", content = @Content(schema = @Schema(implementation = Emprestimo.class)))
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> getEmprestimo(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( emprestimoService.getEmprestimo( id ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Endpoint para exclusão de um emprestimo no banco de dados
     * @param id ID do emprestimo
     * @return Void
     */
    @Operation(summary = "Endpoint para exclusão de um emprestimo no banco de dados", description = "Retorna o emprestimo excluido")
    @ApiResponse(responseCode = "204", description = "Emprestimo excluido com sucesso", content = @Content(schema = @Schema(implementation = Emprestimo.class)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEmprestimo(@PathVariable Integer id) {
        try {
            emprestimoService.removeEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para atualização de um emprestimo no banco de dados
     * @param id ID do emprestimo
     * @param emprestimo Objeto do tipo emprestimo
     * @return Objeto do tipo emprestimo
     */
    @Operation(summary = "Endpoint para atualização de um emprestimo no banco de dados", description = "Retorna o emprestimo atualizado")
    @ApiResponse(responseCode = "200", description = "Emprestimo atualizado com sucesso", content = @Content(schema = @Schema(implementation = Emprestimo.class)))
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> updateEmprestimo(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        try {
            return new ResponseEntity<>(emprestimoService.updateEmprestimo(id, emprestimo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
