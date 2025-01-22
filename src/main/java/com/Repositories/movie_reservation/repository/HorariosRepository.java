package com.Repositories.movie_reservation.repository;


import com.Cine.Project.Movies_Reservation_Rico_Project.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Integer> { //extends JpaRepository<Horarios, Integer> para poder usar los metodos de JpaRepository

}
