package com.Cine.Project.Autor.Project;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservation;

    //Llaves Foraneas

    @ManyToOne
    @JoinColumn(name = "id_showtime", nullable = false)
    private Horarios horarios;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User usuario;

    @Column(nullable = false)
    private int number_of_tickets;

    @Column(nullable = false)
    private int total_price;

    @Column(nullable = false)
    private LocalDate reservation_date;

    public Reserva() {
    }

    public Reserva(Horarios horarios, User usuario, int number_of_tickets, int total_price, LocalDate reservation_date) {
        this.horarios = horarios;
        this.usuario = usuario;
        this.number_of_tickets = number_of_tickets;
        this.total_price = total_price;
        this.reservation_date = reservation_date;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Horarios getHorarios() {
        return horarios;
    }

    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public int getNumber_of_tickets() {
        return number_of_tickets;
    }

    public void setNumber_of_tickets(int number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public LocalDate getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(LocalDate reservation_date) {
        this.reservation_date = reservation_date;
    }

}
