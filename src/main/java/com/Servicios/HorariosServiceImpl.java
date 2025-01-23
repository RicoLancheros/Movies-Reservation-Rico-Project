package com.Servicios;


import com.Cine.Project.Movies_Reservation_Rico_Project.Horarios;
import com.Repositories.movie_reservation.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorariosServiceImpl implements HorarioService {

    //Aqui se inyecta la dependencia del repositorio
    private final HorariosRepository horariosRepository;

    //Aqui tambien inyecta la dependencia del repositorio (del de arriba y el de abajo son igual de necesarios)
    @Autowired
    public HorariosServiceImpl(HorariosRepository horariosRepository) {
        this.horariosRepository = horariosRepository;
    }

    //Aqui se implementan los metodos de la interfaz HorarioService

    //Aqui se crea un horario
    @Override
    public Horarios CrearHorario(Horarios horarios) {
        //aqui se añaden las validaciones, o logica del negocio
        return horariosRepository.save(horarios);
    }

    //Aqui se obtiene un horario por su id
    @Override
    public Optional<Horarios> obtenerHorarioPorId(Integer id) {
        return horariosRepository.findById(id);
    }

    //Aqui se listan todos los horarios
    @Override
    public List<Horarios> listarTodosLosHorarios() {
        return horariosRepository.findAll();
    }

    //Aqui se actualiza un horario
    @Override
    public Horarios actualizarHorario(Integer id, Horarios horarioActualizado) {
        Optional<Horarios> horarioExistenteOptional = horariosRepository.findById(id);
        if(horarioExistenteOptional.isPresent()) {
            Horarios horarioExistente = horarioExistenteOptional.get();
            //Actualizar los campos permitidos
            horarioExistente.setPelicula(horarioActualizado.getPelicula());
            horarioExistente.setTeatro(horarioActualizado.getTeatro());
            horarioExistente.setShow_date(horarioActualizado.getShow_date());
            horarioExistente.setShow_time(horarioActualizado.getShow_time());
            //No se actualiza la fecha de creación (se actualiza sola con el metodo save)

            return horariosRepository.save(horarioExistente);
        }else{
            return null; //Lanza una Excepción o devuelve un valor por defecto
        }
    }

    //Aqui se elimina un horario
    @Override
    public boolean eliminarHorario(Integer id) {
        if (horariosRepository.existsById(id)) {
            horariosRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
