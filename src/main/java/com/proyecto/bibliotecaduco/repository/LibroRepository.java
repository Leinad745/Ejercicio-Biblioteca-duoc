package com.proyecto.bibliotecaduco.repository;

import com.proyecto.bibliotecaduco.model.Libro;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class LibroRepository {
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository() {
        listaLibros.add(new Libro(1, "9784065189881", "Attack on Titan", "Kodansha", LocalDate.of(2009, 3, 17), "Hajime Isayama"));
        listaLibros.add(new Libro(2, "9784088704531", "One Piece", "Shueisha", LocalDate.of(1997, 7, 22), "Eiichiro Oda"));
        listaLibros.add(new Libro(3, "9784088725086", "Naruto", "Shueisha", LocalDate.of(1999, 9, 21), "Masashi Kishimoto"));
        listaLibros.add(new Libro(4, "9784088815084", "My Hero Academia", "Shueisha", LocalDate.of(2014, 7, 7), "Kohei Horikoshi"));
        listaLibros.add(new Libro(5, "9784063959387", "Fairy Tail", "Kodansha", LocalDate.of(2006, 8, 23), "Hiro Mashima"));
        listaLibros.add(new Libro(6, "9784088821658", "Jujutsu Kaisen", "Shueisha", LocalDate.of(2018, 3, 5), "Gege Akutami"));
        listaLibros.add(new Libro(7, "9784088726847", "Death Note", "Shueisha", LocalDate.of(2003, 12, 1), "Tsugumi Ohba"));
        listaLibros.add(new Libro(8, "9784088707013", "Bleach", "Shueisha", LocalDate.of(2001, 8, 20), "Tite Kubo"));
        listaLibros.add(new Libro(9, "9784065199859", "Tokyo Revengers", "Kodansha", LocalDate.of(2017, 3, 1), "Ken Wakui"));
        listaLibros.add(new Libro(10, "9784091269084", "Inuyasha", "Shogakukan", LocalDate.of(1996, 11, 13), "Rumiko Takahashi"));
    }

    public List<Libro> obtenerListaLibros() {
        return listaLibros;
    }

    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        } return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        } return null;
    }

    public Libro guardarLibro(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }

    public Libro actualizarLibro(Libro libro) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i=i+1) {
            if (listaLibros.get(i).getId() == libro.getId()) {
                id = libro.getId();
                idPosicion = i;
            }
        }
        
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setIsbn(libro.getIsbn());
        libro1.setTitulo(libro.getTitulo());
        libro1.setEditorial(libro.getEditorial());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());
        libro1.setAutor(libro.getAutor());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    public void eliminarLibro(int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
    }

    public int totalLibros() {
        return listaLibros.size();
    }

    public int buscarLibrosPorAno(int ano) {
        int i = 0;

        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion().getYear() == ano) {
                i = i + 1;
            } 
        }
        return i;
    }

    public Libro buscarPorAutor(String autor) {
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        } return null;
    }

    public Libro buscarLibroMasAntiguo() {
            LocalDate fechaMasAntigua = null;
            Libro libroMasAntiguo = null;

            for (Libro lib : listaLibros) {
                if (lib.getFechaPublicacion().isBefore(fechaMasAntigua)) {
                    fechaMasAntigua = lib.getFechaPublicacion();
                    libroMasAntiguo = lib;
                }
            } return libroMasAntiguo;
    }

    public Libro buscarLibroMasReciente() {
        LocalDate fechaMasReciente = LocalDate.MIN;
        Libro libroMasAntiguo = null;

        for (Libro lib : listaLibros) {
            if (lib.getFechaPublicacion().isAfter(fechaMasReciente)) {
                fechaMasReciente = lib.getFechaPublicacion();
                libroMasAntiguo = lib;
            }
        } return libroMasAntiguo;
}

    public List<Libro> librosOrdenCronologico() {
        List<Libro> librosOrdenados = new ArrayList<>(listaLibros); // Crea una copia de la lista original
        librosOrdenados.sort(Comparator.comparing(Libro -> Libro.getFechaPublicacion())); //Ordena la lista usando de comparador la fecha de publicacion
        return librosOrdenados;
        }
    }