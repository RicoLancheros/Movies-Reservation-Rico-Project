package com.Servicios;

import com.Cine.Project.Movies_Reservation_Rico_Project.Pelicula;
import com.Repositories.movie_reservation.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        // Aquí se añaden las validaciones, o logica del negocio
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Pelicula> obtenerPeliculaPorId(Integer id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public List<Pelicula> listarTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula actualizarPelicula(Integer id, Pelicula peliculaActualizada){ //se define la variable de "Pelicula actualizada" y abajo, la "peliculaExistenteOptional tambien"
        Optional<Pelicula> peliculaExistenteOptional = peliculaRepository.findById(id); //el Optional<Pelicula> se define como "peliculaExistenteOptional", y luego se compara con el metodo "findById" que se le pasa el id
        if (peliculaExistenteOptional.isPresent()) { //se compara si el "peliculaExistenteOptional" esta presente
            Pelicula peliculaExistente = peliculaExistenteOptional.get(); //se define la variable "peliculaExistente" y se le asigna el valor de "peliculaExistenteOptional.get()"
            //Actualizar los campos permitidos
            peliculaExistente.setTitulo(peliculaActualizada.getTitulo()); //se actualizan todos los campos permitidos
            peliculaExistente.setDescripcion(peliculaActualizada.getDescripcion());
            peliculaExistente.setDuracion_minutes(peliculaActualizada.getDuracion_minutes());
            peliculaExistente.setLanguaje(peliculaActualizada.getLanguaje());

            return peliculaRepository.save(peliculaExistente);
        } else {
            return null; //Lanza una Excepción o devuelve un valor por defecto
        }
    }

    @Override
    public boolean eliminarPelicula(Integer id) {
        if (peliculaRepository.existsById(id)){
            peliculaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
