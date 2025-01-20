package com.Repositories.movie_reservation.repository;

import com.Cine.Project.Movies_Reservation_Rico_Project.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

}

