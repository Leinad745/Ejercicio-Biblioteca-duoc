package com.proyecto.bibliotecaduco.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // ESTA ANOTACION GENERA LOS GETTERS Y SETTERS DE CADA ATRIBUTO
@AllArgsConstructor //ESTAS ANOTACIONES GENERAN EL CONSTRUCTOR CON TODOS LOS PARAMETROS
@NoArgsConstructor //ESTAS ANOTACIONES GENERAN EL CONSTRUCTOR SIN PARAMETROS

public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private LocalDate fechaPublicacion;
    private String autor;
}
