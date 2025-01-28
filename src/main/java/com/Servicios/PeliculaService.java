package com.Servicios;

import com.Cine.Project.Autor.Project.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    Pelicula crearPelicula(Pelicula pelicula);

    Optional<Pelicula> obtenerPeliculaPorId(Integer id);

    List<Pelicula> listarTodasLasPeliculas();

    Pelicula actualizarPelicula(Integer id, Pelicula peliculaActualizada);

    boolean eliminarPelicula(Integer id);
}
