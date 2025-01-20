package com.Cine.Project.Movies_Reservation_Rico_Project;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_usuario;

        @Column(nullable = false, length = 100)
        private String nombre;

        @Column(nullable = false, length = 254)
        private String email;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Rol rol = Rol.NORMAL;

        @Column(nullable = false, length = 100)
        private String contrasena;

        @Column(name = "fecha_registro_at")
        private LocalDateTime fecha_registro_at;


            public User() {
            }

            public User(String nombre, String email, Rol rol, String contrasena) {
                this.nombre = nombre;
                this.email = email;
                this.rol = rol;
                this.contrasena = contrasena;
                this.fecha_registro_at = LocalDateTime.now(); // Establecer la fecha de registro al crear el usuario
           }
            public Integer getIdUsuario() {return id_usuario;}


            public void setIdUsuario(Integer idUsuario) {
                this.id_usuario = idUsuario;
           }

            public String getNombre() {
                return nombre;
           }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Rol getRol() {
                return rol;
            }

            public void setRol(Rol rol) {
                this.rol = rol;
            }

            public String getContrasena() {
                return contrasena;
            }

            public void setContrasena(String contrasena) {
                this.contrasena = contrasena;
            }

            public LocalDateTime getFechaRegistro() {
                return fecha_registro_at;
            }

            public void setFechaRegistro(LocalDateTime fechaRegistro) {
                this.fecha_registro_at = fechaRegistro;
            }


}

