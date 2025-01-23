package com.Servicios;

import com.Cine.Project.Movies_Reservation_Rico_Project.Reserva;
import com.Repositories.movie_reservation.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    //Aqui se crea una reserva
    @Override
    public Reserva CrearReserva(Reserva reserva) {
        //aqui se añaden las validaciones, o logica del negocio
        return reservaRepository.save(reserva);
    }

    //Aqui se obtiene una reserva por su id
    @Override
    public Optional<Reserva> obtenerReservaPorId(Integer id) {
        return reservaRepository.findById(id);
    }

    //Aqui se listan todas las reservas
    @Override
    public List<Reserva> listarTodasLasReservas() {
        return reservaRepository.findAll();
    }

    //Aqui se actualiza una reserva
    @Override
    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada) {
        Optional<Reserva> reservaExistenteOptional = reservaRepository.findById(id);
        if(reservaExistenteOptional.isPresent()) {
            Reserva reservaExistente = reservaExistenteOptional.get();
            //Actualizar los campos permitidos
            reservaExistente.setHorarios(reservaActualizada.getHorarios());
            reservaExistente.setUsuario(reservaActualizada.getUsuario());
            reservaExistente.setNumber_of_tickets(reservaActualizada.getNumber_of_tickets());
            reservaExistente.setTotal_price(reservaActualizada.getTotal_price());
            //No se actualiza la fecha de creación

            return reservaRepository.save(reservaExistente);
        }else{
            return null; //Lanza una Excepción o devuelve un valor por defecto
        }
    }

    //Aqui se elimina una reserva

    @Override
    public boolean eliminarReserva(Integer id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
