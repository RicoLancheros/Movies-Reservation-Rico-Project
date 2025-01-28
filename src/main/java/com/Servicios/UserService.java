package com.Servicios;

import com.Cine.Project.Autor.Project.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User crearUsuario(User usuario);

    Optional<User> obtenerUsuarioPorId(Integer id);

    Optional<User> obtenerUsuarioPorEmail(String email);

    List<User> listarTodosLosUsuarios();

    User actualizarUsuario(Integer id, User usuarioActualizado);

    boolean eliminarUsuario(Integer id);

}