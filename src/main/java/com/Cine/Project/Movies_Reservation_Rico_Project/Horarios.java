package com.Cine.Project.Movies_Reservation_Rico_Project;


import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Horarios")
public class Horarios {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_showtime;

    @ManyToOne // Relación Muchos a Uno con Pelicula
    @JoinColumn(name = "id_movie", nullable = false) // Clave foránea en la tabla Horarios
    private Pelicula pelicula; // Referencia a la entidad Pelicula

    @ManyToOne // Relación Muchos a Uno con Teatro
    @JoinColumn(name = "id_theater", nullable = false) // Clave foránea en la tabla Horarios
    private Teatro teatro; // Referencia a la entidad Teatro

    @Column(nullable = false)
    private LocalDate show_date; // Usar LocalDate para la fecha sin tiempo

    @Column(nullable = false)
    private LocalTime show_time; // Usar LocalTime para la hora sin fecha

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;


    //Constructores
    public Horarios() {
    }

    public Horarios(Pelicula pelicula, Teatro teatro, LocalDate show_date, LocalTime show_time) {
        this.pelicula = pelicula;
        this.teatro = teatro;
        this.show_date = show_date;
        this.show_time = show_time;
        this.createdAt = LocalDateTime.now();
    }


    //Getters y Setters
    public Integer getId_showtime() {
        return id_showtime;
    }

    public void setId_showtime(Integer id_showtime) {
        this.id_showtime = id_showtime;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public LocalDate getShow_date() {
        return show_date;
    }

    public void setShow_date(LocalDate show_date) {
        this.show_date = show_date;
    }

    public LocalTime getShow_time() {
        return show_time;
    }

    public void setShow_time(LocalTime show_time) {
        this.show_time = show_time;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
