package com.Servicios;

import com.Cine.Project.Autor.Project.Reserva;

import java.util.List;
import java.util.Optional;

//esta interfaz define los metodos que se implementaran en la clase ReservaServiceImpl
public interface ReservaService {

    //metodos que se implementaran en la clase ReservaServiceImpl
    Reserva CrearReserva(Reserva reserva);

    //metodo que se implementara en la clase ReservaServiceImpl
    Optional<Reserva> obtenerReservaPorId(Integer id);

    //metodo que se implementara en la clase ReservaServiceImpl
    List<Reserva> listarTodasLasReservas();

    //metodo que se implementara en la clase ReservaServiceImpl
    boolean eliminarReserva(Integer id);

    //metodo que se implementara en la clase ReservaServiceImpl
    Reserva actualizarReserva(Integer id, Reserva reservaActualizada);

}
