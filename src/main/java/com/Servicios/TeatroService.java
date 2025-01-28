package com.Servicios;

import com.Cine.Project.Autor.Project.Teatro;

import java.util.List;
import java.util.Optional;

public interface TeatroService {

    Teatro crearTeatro(Teatro teatro);

    Optional<Teatro> obtenerTeatroPorId(Integer id);

    List<Teatro> listarTodosLosTeatros();

    Teatro actualizarTeatro(Integer id, Teatro teatroActualizado);

    boolean eliminarTeatro(Integer id);
}
