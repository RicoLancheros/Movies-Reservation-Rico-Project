package com.Repositories.movie_reservation.repository;


import com.Cine.Project.Movies_Reservation_Rico_Project.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    @Override
    Optional<User> findById(Integer integer);
}