package com.proyecto.bibliotecaduco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prestamo {
    private int id_prestamo;
    private int id_libro;
    private String run_solicitante;
    private LocalDate fecha_solicitud;
    private LocalDate fecha_entrega;
    private int cantidad_dias;
    private int multas;
}
