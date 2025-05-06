package com.proyecto.bibliotecaduco.services;

import com.proyecto.bibliotecaduco.model.Libro;
import com.proyecto.bibliotecaduco.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerListaLibros();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardarLibro(libro);
    }

    public Libro getLibroId(int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.actualizarLibro(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminarLibro(id);
        return "Libro eliminado con exito";
    }

    public Libro getLibroIsbn(String isbn) {
        return libroRepository.buscarPorIsbn(isbn);
    }

   public int totalLibros() {
    return libroRepository.totalLibros();
    }

    public int getLibrosPorAno(int año) {
        return libroRepository.buscarLibrosPorAno(año);
    }

    public Libro getLibrosPorAutor(String autor) {
        return libroRepository.buscarPorAutor(autor);
    }

    public Libro getLibroMasAntiguo() {
        return libroRepository.buscarLibroMasAntiguo();
    }

    public Libro getLibroMasReciente() {
        return libroRepository.buscarLibroMasReciente();
    }

    public List<Libro> getLibrosOrdenCronologico() {
        return libroRepository.librosOrdenCronologico();
    }
}
