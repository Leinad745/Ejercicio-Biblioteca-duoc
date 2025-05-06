package com.proyecto.bibliotecaduco.controller;

import com.proyecto.bibliotecaduco.model.Libro;
import com.proyecto.bibliotecaduco.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired //Injecta la dependencia de LibroService
    private LibroService libroService;
    
    @GetMapping //GET http://localhost:8080/api/v1/libros
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @PostMapping //POST http://localhost:8080/api/v1/libros
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }
    
    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return libroService.getLibroId(id);
    }
    
    @PutMapping("{id}")
    public Libro actualizaLibro(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibros() {
        return libroService.totalLibros();
    }

    @GetMapping("/total/{ano}")
    public int totalLibrosPorAno(@PathVariable int ano) {
        return libroService.getLibrosPorAno(ano);
    }

    @GetMapping("/autor/{autor}")
    public Libro librosAutor(@PathVariable String autor) {
        return libroService.getLibrosPorAutor(autor);
    }
    
    @GetMapping("/oldest")
    public Libro libroMasAntiguo() {
        return libroService.getLibroMasAntiguo();
    }

    @GetMapping("/newest")
    public Libro libroMasReciente() {
        return libroService.getLibroMasReciente();
    }

    @GetMapping("/chronological")
    public List<Libro> librosOrdenCronologico() {
        return libroService.getLibrosOrdenCronologico();
    }
    
}