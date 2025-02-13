package com.weg.biblioteca.Controller;

import com.weg.biblioteca.Model.Livro;
import com.weg.biblioteca.Service.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/livro")
public class LivroController {

    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> postLivro(@RequestBody Livro livro) {
        try {
            return new ResponseEntity<>( livroService.postLivro( livro ) , HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getLivros() {
        try {
            return new ResponseEntity<>( livroService.getLivros() , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivro(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( livroService.getLivro( id ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<List<Livro>> getLivrosByAutor(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( livroService.getLivrosByAutor( id ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
    //localhost:8081/livro/autor/?idAutor=1&idLivro=1
    @PatchMapping("/autor/")
    public ResponseEntity<Livro> cadastrarAutor(@RequestParam Integer idLivro, @RequestParam Integer idAutor) {
        try {
            return new ResponseEntity<>( livroService.cadastrarAutor( idAutor, idLivro ) , HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
