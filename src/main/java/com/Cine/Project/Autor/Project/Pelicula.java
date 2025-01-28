package com.Cine.Project.Autor.Project;

import jakarta.persistence.*;

@Entity
@Table
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_movie;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private int duracion_minutes;

    @Column(nullable = false, length = 50)
    private String languaje;


//Constructores

public Pelicula() {
}

public Pelicula(String titulo, String descripcion, int duracion_minutes, String languaje) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.duracion_minutes = duracion_minutes;
    this.languaje = languaje;
}

//Getters y Setters

public Integer getId_movie() {
    return id_movie;
}

public void setId_movie(Integer id_movie) {
    this.id_movie = id_movie;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public int getDuracion_minutes() {
    return duracion_minutes;
}

public void setDuracion_minutes(int duracion_minutes) {
    this.duracion_minutes = duracion_minutes;
}

public String getLanguaje() {
    return languaje;
}

public void setLanguaje(String languaje) {
    this.languaje = languaje;
}
}

