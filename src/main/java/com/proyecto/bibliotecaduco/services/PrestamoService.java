package com.proyecto.bibliotecaduco.services;

import com.proyecto.bibliotecaduco.model.Prestamo;
import com.proyecto.bibliotecaduco.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrestamoService {
    // Inyectar el repositorio de prestamos
    // para poder acceder a los métodos de la base de datos
    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> getPrestamos() {
        return prestamoRepository.obtenerListaPrestamos();
    }

    public Prestamo getPrestamo(int id) {
        return prestamoRepository.obtenerPrestamo(id);
    }

    public Prestamo listPrestamos() {
        return prestamoRepository.listarPrestamos();
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.guardarPrestamo(prestamo);
    }

    public Prestamo updatePrestamo(Prestamo prestamo) {
        return prestamoRepository.actualizarPrestamo(prestamo);
    }

    public String deletePrestamo(int id) {
        prestamoRepository.eliminarLibro(id);
        return "Libro retornado con exito";
    }
}
