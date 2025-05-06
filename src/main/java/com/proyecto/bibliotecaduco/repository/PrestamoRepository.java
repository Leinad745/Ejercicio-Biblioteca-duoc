package com.proyecto.bibliotecaduco.repository;

import com.proyecto.bibliotecaduco.model.Prestamo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PrestamoRepository {

    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public PrestamoRepository() {
        listaPrestamos.add(new Prestamo(1, 1, "12.345.678-9", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 8), 7, 0));
    listaPrestamos.add(new Prestamo(2, 2, "10.111.222-3", LocalDate.of(2025, 4, 2), LocalDate.of(2025, 4, 9), 7, 0));
    listaPrestamos.add(new Prestamo(3, 3, "15.987.654-1", LocalDate.of(2025, 4, 3), LocalDate.of(2025, 4, 12), 9, 500));
    listaPrestamos.add(new Prestamo(4, 4, "18.456.789-0", LocalDate.of(2025, 4, 4), LocalDate.of(2025, 4, 11), 7, 0));
    listaPrestamos.add(new Prestamo(5, 5, "16.123.456-7", LocalDate.of(2025, 4, 5), LocalDate.of(2025, 4, 14), 9, 300));
    listaPrestamos.add(new Prestamo(6, 6, "17.654.321-0", LocalDate.of(2025, 4, 6), LocalDate.of(2025, 4, 13), 7, 0));
    listaPrestamos.add(new Prestamo(7, 7, "14.321.678-5", LocalDate.of(2025, 4, 7), LocalDate.of(2025, 4, 10), 3, 0));
    listaPrestamos.add(new Prestamo(8, 8, "11.222.333-4", LocalDate.of(2025, 4, 8), LocalDate.of(2025, 4, 15), 7, 0));
    listaPrestamos.add(new Prestamo(9, 9, "13.333.444-5", LocalDate.of(2025, 4, 9), LocalDate.of(2025, 4, 18), 9, 200));
    listaPrestamos.add(new Prestamo(10, 10, "19.555.666-7", LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 17), 7, 0));

    }

    public List<Prestamo> obtenerListaPrestamos() {
        return listaPrestamos;
    }
    //OBTENER PRESTAMO

    public Prestamo obtenerPrestamo(int id) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId_prestamo() == id) {
                return prestamo;
            }
        } return null;
    }

    //LISTAR PRESTAMOS

    public Prestamo listarPrestamos() {
        for (Prestamo prestamo : listaPrestamos) {
            return prestamo;
        } return null;
    }

    //Guardar prestamo

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
        return prestamo;
    }

    //Actualizar prestamo

    public Prestamo actualizarPrestamo(Prestamo prestamo) {
        int id = 0;
        int idPosicion = 0;
        
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getId_prestamo() == prestamo.getId_prestamo()) {
                id = prestamo.getId_prestamo();
                idPosicion = i;
            }
        }

        Prestamo prestamoActualizado = new Prestamo();

        prestamoActualizado.setId_prestamo(id);
        prestamoActualizado.setId_libro(prestamo.getId_libro());
        prestamoActualizado.setRun_solicitante(prestamo.getRun_solicitante());
        prestamoActualizado.setFecha_solicitud(prestamo.getFecha_solicitud());
        prestamoActualizado.setFecha_entrega(prestamo.getFecha_entrega());
        prestamoActualizado.setCantidad_dias(prestamo.getCantidad_dias());
        prestamoActualizado.setMultas(prestamo.getMultas());

        listaPrestamos.set(idPosicion, prestamoActualizado);


        return prestamoActualizado;
    }

    //Eliminar prestamo

    public void eliminarLibro(int id) {
        Prestamo prestamo = obtenerPrestamo(id);
        if (prestamo != null) {
            listaPrestamos.remove(prestamo);
        }
    }
}
