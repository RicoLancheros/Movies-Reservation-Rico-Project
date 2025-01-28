package com.Repositories.movie_reservation.repository;


import com.Cine.Project.Autor.Project.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeatroRepository extends JpaRepository<Teatro, Integer> {

}
