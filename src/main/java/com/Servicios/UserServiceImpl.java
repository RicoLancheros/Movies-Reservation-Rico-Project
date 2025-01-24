package com.Servicios;


import com.Cine.Project.Movies_Reservation_Rico_Project.User;
import com.Repositories.movie_reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User crearUsuario(User user) {
        return userRepository.save(user);
    }

    //
    @Override
    public Optional<User> obtenerUsuarioPorId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> obtenerUsuarioPorEmail(String email) {
        // **IMPLEMENTACIÓN PENDIENTE: Buscar por email en el UserRepository**
        // Por ahora, retornamos un Optional vacío como ejemplo.
        return Optional.empty(); // **TODO: Implementar la búsqueda real por email**
    }

    @Override
    public List<User> listarTodosLosUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public User actualizarUsuario(Integer id, User usuarioActualizado) {
        Optional<User> usuarioExistenteOptional = userRepository.findById(id);
        if (usuarioExistenteOptional.isPresent()) {
            User usuarioExistente = usuarioExistenteOptional.get();
            // Actualizar los campos del usuario existente con los valores del usuarioActualizado
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            usuarioExistente.setContrasena(usuarioActualizado.getContrasena());
            // No actualizamos la fecha de registro

            return userRepository.save(usuarioExistente); // Guardar el usuario actualizado
        } else {
            return null; // O lanzar una excepción indicando que el usuario no existe
        }
    }

    @Override
    public boolean eliminarUsuario(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false; // O lanzar una excepción indicando que el usuario no existe
        }
    }

}
