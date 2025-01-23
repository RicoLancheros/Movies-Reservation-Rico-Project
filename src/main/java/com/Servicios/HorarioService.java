package com.Servicios;

import com.Cine.Project.Movies_Reservation_Rico_Project.Horarios;

import java.util.List;
import java.util.Optional;

public interface HorarioService {

    Horarios CrearHorario(Horarios horarios);

    Optional<Horarios> obtenerHorarioPorId(Integer id);

    List<Horarios> listarTodosLosHorarios();

    Horarios actualizarHorario(Integer id, Horarios horarioActualizado);

    boolean eliminarHorario(Integer id);


}
