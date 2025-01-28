package com.Cine.Project.Autor.Project;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Teatro {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_theater;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 200)
    private String location;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private LocalDateTime created_at;

    public Teatro() {
    }

    public Teatro(String name, String location, int capacity, int created_at) { //Constructor
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.created_at = LocalDateTime.now();

    }

    //Getters y Setters
    public Integer getId_theater() {
        return id_theater;
    }

    public void setId_theater(Integer id_theater) {
        this.id_theater = id_theater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


}


