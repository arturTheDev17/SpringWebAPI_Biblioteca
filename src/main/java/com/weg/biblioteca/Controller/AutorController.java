package com.weg.biblioteca.Controller;

import com.weg.biblioteca.Model.Autor;
import com.weg.biblioteca.Service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> postAutor( @RequestBody Autor autor ) {
        try {
            return new ResponseEntity<>(autorService.postAutor(autor), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAutores() {
        try {
            return new ResponseEntity<>(autorService.getAutores(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(autorService.getAutor(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
