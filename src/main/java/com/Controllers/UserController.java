package com.Controllers;


import com.Cine.Project.Movies_Reservation_Rico_Project.User;
import com.Servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // esta anotación indica que esta clase es un controlador REST
@RequestMapping // Mapea las peticiones HTTP con prefijo "/api/users" a este controlador
public class UserController {

    private final UserService userService; // Inyectamos el servicio UserService

    @Autowired // esta etiqueta @autowired inyecta el servicio UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Endpoint para crear un usuario (POST /api/users)
    @PostMapping
    public ResponseEntity<User> crearUsuario(@RequestBody User usuario) {
        User nuevoUsuario = userService.crearUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED); //Retorna el nuevo usuario creado y el codigo 201 created
    }


    @GetMapping("/{id}") //Endpoint para obtener un usuario por su id (GET /api/users/{id})
    public ResponseEntity<User> obtenerUsuarioPorId(@PathVariable Integer id) {
        Optional<User> usuarioOptional = userService.obtenerUsuarioPorId(id);
        if (usuarioOptional.isPresent()) {
            return new ResponseEntity<>(usuarioOptional.get(), HttpStatus.OK); // Retorna el usuario y el código 200 OK
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna el código 404 Not Found

        }
    }

    // Endpoint para listar todos los usuarios (GET /api/users)
    @GetMapping
    public ResponseEntity<List<User>> listarTodosLosUsuarios() {
        List<User> usuarios = userService.listarTodosLosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK); // Retorna la lista de usuarios y el código 200 OK
    }

    // Endpoint para actualizar un usuario existente (PUT /api/users/{id})
    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarUsuario(@PathVariable Integer id, @RequestBody User usuarioActualizado) {
        User usuario = userService.actualizarUsuario(id, usuarioActualizado);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK); // Retorna el usuario actualizado y el código 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna el código 404 Not Found si no se encuentra el usuario a actualizar
        }
    }

    // Endpoint para eliminar un usuario por su ID (DELETE /api/users/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        boolean eliminado = userService.eliminarUsuario(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna el código 204 No Content si se eliminó correctamente
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna el código 404 Not Found si no se encontró el usuario a eliminar
            // o si ocurrió un error al eliminarlo (NOTA 27)
        }
    }
}
