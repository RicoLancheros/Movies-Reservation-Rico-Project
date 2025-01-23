package com.Servicios;

import com.Cine.Project.Movies_Reservation_Rico_Project.Teatro;
import com.Repositories.movie_reservation.repository.TeatroRepository; // Check this import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeatroServiceImpl implements TeatroService {

    private final TeatroRepository teatroRepository;

    @Autowired
    public TeatroServiceImpl(TeatroRepository teatroRepository) {
        this.teatroRepository = teatroRepository;
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) {
        return teatroRepository.save(teatro);
    }

    @Override
    public Optional<Teatro> obtenerTeatroPorId(Integer id) {
        return teatroRepository.findById(id);
    }

    @Override
    public List<Teatro> listarTodosLosTeatros() {
        return teatroRepository.findAll();
    }

    @Override
    public Teatro actualizarTeatro(Integer id, Teatro teatroActualizado) {
        Optional<Teatro> teatroExistenteOptional = teatroRepository.findById(id);
        if(teatroExistenteOptional.isPresent()) {
            Teatro teatroExistente = teatroExistenteOptional.get();
            //Actualizar los campos permitidos
            teatroExistente.setName(teatroActualizado.getName());
            teatroExistente.setLocation(teatroActualizado.getLocation());
            teatroExistente.setCapacity(teatroActualizado.getCapacity());
            teatroExistente.setCreated_at(teatroActualizado.getCreated_at()); //Actualizado Versión 0.2.4.1

            //No se actualiza la fecha de creación

            return teatroRepository.save(teatroExistente);
        }else{
            return null; //Lanza una Excepción o devuelve un valor por defecto
            }
        }

    @Override
    public boolean eliminarTeatro(Integer id) {
        if (teatroRepository.existsById(id)) {
            teatroRepository.deleteById(id);
            return true;
        } else {
            throw new EmptyResultDataAccessException("Teatro not found with id: " + id,1);
          }
   }
}