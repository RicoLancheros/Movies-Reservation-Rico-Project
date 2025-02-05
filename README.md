# Movies-Reservation-Rico-Project


////////////////////////////////////////////////////////////////////////////////////////////////////
Versión 0.3.1.3: 2021-09-01 2:17 PM, El proyecto se finaliza con la versión actual.
Principalmente por el inicio de un nuevo proyecto (De el mismo Ambito)
el cual se puede encontrar en mi mismo Github: https://github.com/RicoLancheros/Movies-Reservation-Modulate-Project-RICO
Si alguien esta leyendo esto, gracias por revisar mi proyecto anterior!, Aprendi mucho de este y seguire aprendiendo en el siguiente!
gg wp <3
////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////

NOTAS DE VERCION Y DOCUMENTACION:

# Documentación del Proyecto: Sistema de Reservas de Cine 
 Alejandro Rico Lancheros (Versión 0.1)

 Nombre del Proyecto: Movies-Reservation-Rico-Project

Inspiración: Este proyecto se basa en la idea del proyecto "Movie Reservation System" de roadmap.sh (https://roadmap.sh/projects/movie-reservation-system). El objetivo es construir un sistema completo de reservas de asientos de cine.

Versión 0.1 Inicio (19/01/2025)

El proyecto "Movies-Reservation-Rico-Project" es un sistema de reservas de asientos de cine desarrollado como un proyecto de aprendizaje. La meta es crear una aplicación web funcional que permita a los usuarios ver las películas disponibles, los horarios de proyección, seleccionar asientos y realizar reservas. La versión 0.1 se centra en la configuración inicial del backend y la base de datos.

Tecnologías Utilizadas:

*   Lenguaje de Programación: Java 17
*   Framework Backend: Spring Boot
*   Frontend:React (planificado para futuras versiones)
*   Base de Datos: MySQL
*   Herramienta de Desarrollo: IntelliJ IDEA
*   Gestor de Dependencias: Maven

////////////////////////////////////////////////////////////////////////////////////////////////////////////

Progreso Actual (Versión 0.1):

#En esta etapa inicial del proyecto, se han completado las siguientes tareas:

*   **Creación de la Base de Datos:** Se ha diseñado y creado el esquema de la base de datos MySQL llamado `movie_reservation`.
*   **Conexión a la Base de Datos:** El proyecto Spring Boot ha sido configurado para conectarse correctamente a la base de datos `movie_reservation`.
*   **Configuración del SDK:** Se ha configurado el entorno de desarrollo con Java 17 y las dependencias necesarias de Spring Boot.
*   **Configuración de `application.properties`:** Se ha configurado el archivo `application.properties` para establecer la conexión a la base de datos, las propiedades de JPA y otras configuraciones iniciales.



Esquema de la Base de Datos:
La base de datos `movie_reservation` contiene las siguientes tablas:

*   **`users`:** Almacena la información de los usuarios del sistema.
    *   `id_usuario` (INT, AUTO_INCREMENT, PRIMARY KEY): Identificador único del usuario.
    *   `nombre` (VARCHAR(100), NOT NULL): Nombre del usuario.
    *   `email` (VARCHAR(254), NOT NULL, UNIQUE): Correo electrónico del usuario (debe ser único).
    *   `rol` (ENUM('NORMAL', 'ADMIN'), NOT NULL, DEFAULT 'NORMAL'): Rol del usuario (NORMAL o ADMIN).
    *   `contrasena` (VARCHAR(100), NOT NULL): Contraseña del usuario (sin encriptar en esta versión inicial).
    *   `fecha_registro_at` (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP): Fecha y hora de registro del usuario.

*   **`peliculas`:** Almacena la información de las películas.
    *   `id_movie` (INT, AUTO_INCREMENT, PRIMARY KEY): Identificador único de la película.
    *   `titulo` (VARCHAR(200), NOT NULL): Título de la película.
    *   `descripcion` (TEXT): Descripción de la película.
    *   `duracion_minutes` (INT, NOT NULL): Duración de la película en minutos.
    *   `languaje` (VARCHAR(50), NOT NULL): Idioma de la película.

*   **`teatros`:** Almacena la información de los teatros o salas de cine.
    *   `id_theater` (INT, AUTO_INCREMENT, PRIMARY KEY): Identificador único del teatro.
    *   `name` (VARCHAR(100), NOT NULL): Nombre del teatro.
    *   `location` (VARCHAR(200), NOT NULL): Ubicación del teatro.
    *   `capacity` (INT, NOT NULL): Capacidad total de asientos del teatro.
    *   `created_at` (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP): Fecha y hora de creación del registro del teatro.

*   **`Horarios`:** Almacena la información de los horarios de proyección de las películas en los teatros.
    *   `id_showtime` (INT, AUTO_INCREMENT, PRIMARY KEY): Identificador único del horario.
    *   `id_movie` (INT, NOT NULL, FOREIGN KEY referencing `peliculas`): Identificador de la película proyectada.
    *   `id_theater` (INT, NOT NULL, FOREIGN KEY referencing `teatros`): Identificador del teatro donde se proyecta la película.
    *   `show_date` (DATE, NOT NULL): Fecha de la proyección.
    *   `show_time` (TIME, NOT NULL): Hora de inicio de la proyección.
    *   `created_at` (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP): Fecha y hora de creación del registro del horario.

*   **`reservas`: Almacena la información de las reservas realizadas por los usuarios.
    *   `id_reservation` (INT, AUTO_INCREMENT, PRIMARY KEY): Identificador único de la reserva.
    *   `id_showtime` (INT, NOT NULL, FOREIGN KEY referencing `Horarios`): Identificador del horario reservado.
    *   `id_usuario` (INT, NOT NULL, FOREIGN KEY referencing `users`): Identificador del usuario que realizó la reserva.
    *   `number_of_tickets` (INT, NOT NULL): Número de boletos reservados.
    *   `total_price` (DECIMAL(10, 2), NOT NULL): Precio total de la reserva.
    *   `reservation_date` (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP): Fecha y hora de la reserva.

Configuración del Backend (`application.properties`):

```properties
spring.application.name=Movies-Reservation-Rico-Project

# Configuración de la conexión a la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/movie_reservation
spring.datasource.username=root
spring.datasource.password=${MySQL_PSS} #Variable de entorno para la contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.sql.init.mode=Always

# Configuraciones de JPA (Hibernate)
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
  #Muestra las consultas SQL en la consola
spring.jpa.properties.hibernate.format_sql=true
  #Formatea las consultas SQL para mejor legibilidad

# Otras configuraciones (opcional por ahora)
server.port=8080
  #Puerto en el que se ejecutará la aplicación (por defecto es 8080)

# Loggin
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE



////////////////////////////////////////////////////////////////////////////////////////////////////////////



Versión 0.2:

Inicio (20/01/2025)

Explicación del Código (Usuarios)
package com.example.movie_reservation.model;: Define el paquete de la clase.
import jakarta.persistence.*;: Importa las anotaciones de JPA.
import java.time.LocalDateTime;: Importa la clase para manejar fechas y horas.
@Entity: Indica que esta clase es una entidad JPA y se mapea a una tabla de la base de datos.
@Table(name = "users"): Especifica el nombre de la tabla en la base de datos a la que se mapea esta entidad.
@Id: Indica que el campo siguiente es la clave primaria de la tabla.
@GeneratedValue(strategy = GenerationType.IDENTITY): Configura la generación automática de la clave primaria utilizando la estrategia de identidad de la base de datos (auto-incremento en MySQL).
@Column(...): Define las propiedades de cada columna de la tabla.
nullable = false: La columna no puede ser nula.
length = ...: Define la longitud máxima de la columna (para tipos String).
unique = true: Indica que el valor de la columna debe ser único.
name = "fecha_registro_at": Especifica el nombre de la columna en la base de datos si es diferente al nombre del atributo Java.
@Enumerated(EnumType.STRING): Indica que el campo rol es un enum y debe almacenarse como una cadena en la base de datos.
Los getters y setters permiten acceder y modificar los atributos de la clase.




Explicacion del codigo (rol)

package com.example.movie_reservation.model;: Define el paquete del enum.

public enum Rol: Define la enumeración Rol.

NORMAL, ADMIN: Define los posibles valores del enum.

(Se crea Repositories.movie_reservation.repositories)

Explicacion del codigo (rol)

package com.example.movie_reservation.model;: Define el paquete del enum.

public enum Rol: Define la enumeración Rol.

NORMAL, ADMIN: Define los posibles valores del enum.



////////////////////////////////////////////////////////////////////////////////////////////////////////////


Versión 0.3.1: (Peliculas)

package com.Cine.Project.Movies_Reservation_Rico_Project;: Define el paquete al que pertenece esta clase. Asegúrate de que coincida con la estructura de tu proyecto.
import jakarta.persistence.*;: Importa todas las anotaciones necesarias del API de persistencia de Jakarta (JPA).
@Entity: Esta anotación marca la clase Pelicula como una entidad JPA. Esto significa que una instancia de esta clase se mapeará a una fila en una tabla de la base de datos.
@Table(name = "peliculas"): Especifica el nombre de la tabla en la base de datos a la que se mapea esta entidad. En este caso, se mapea a la tabla llamada "peliculas".
@Id: Marca el campo private Integer id_movie; como la clave primaria de la entidad Pelicula. Este campo corresponderá a la columna id_movie en la tabla peliculas.
@GeneratedValue(strategy = GenerationType.IDENTITY): Configura la generación automática del valor de la clave primaria.
strategy = GenerationType.IDENTITY: Indica que la generación de la clave primaria es manejada por la base de datos, utilizando una columna de auto-incremento (como la que definiste en tu esquema de base de datos para id_movie).
@Column(nullable = false, length = 200): Define las propiedades de la columna titulo en la tabla peliculas.
nullable = false: Indica que esta columna no puede contener valores nulos.
length = 200: Define la longitud máxima de la cadena que se puede almacenar en esta columna.
@Column(columnDefinition = "TEXT"): Define las propiedades de la columna descripcion.
columnDefinition = "TEXT": Especifica que el tipo de datos de esta columna en la base de datos debe ser TEXT, que puede almacenar cadenas de texto más largas.
@Column(nullable = false): Define las propiedades de la columna duracion_minutes.
nullable = false: Indica que esta columna no puede contener valores nulos. Por defecto, JPA inferirá el tipo de datos basado en el tipo de Java (en este caso, Integer).
@Column(nullable = false, length = 50): Define las propiedades de la columna languaje.
nullable = false: Indica que esta columna no puede contener valores nulos.
length = 50: Define la longitud máxima de la cadena para el idioma.
public Pelicula() { }: Este es el constructor sin argumentos. Es necesario para que JPA pueda instanciar la entidad.
public Pelicula(String titulo, String descripcion, Integer duracion_minutes, String languaje): Este es un constructor con argumentos. Permite crear una instancia de Pelicula pasando los valores de sus atributos directamente.
public Integer getId_movie() { ... } y public void setId_movie(Integer id_movie) { ... }: Estos son los métodos getter y setter para el atributo id_movie. Permiten acceder y modificar el valor de este atributo desde fuera de la clase.
Los demás getters y setters: Siguen el mismo patrón para los demás atributos de la clase (titulo, descripcion, duracion_minutes, languaje).
Versión 0.3.2: (Peliculas Repository)

package com.Cine.Project.Movies_Reservation_Rico_Project.repositories;: Define el paquete del repositorio. Asegúrate de que coincida con la estructura de tu proyecto.
import com.Cine.Project.Autor.Project.Pelicula;: Importa la clase de entidad Pelicula que acabas de crear.
import org.springframework.data.jpa.repository.JpaRepository;: Importa la interfaz JpaRepository de Spring Data JPA.
import org.springframework.stereotype.Repository;: Importa la anotación @Repository de Spring.
@Repository: Esta anotación marca la interfaz PeliculaRepository como un componente de repositorio en Spring. Esto permite que Spring gestione esta interfaz y proporcione la implementación necesaria en tiempo de ejecución.
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>: Declara la interfaz PeliculaRepository que extiende JpaRepository.
JpaRepository<Pelicula, Integer>: Esta es una interfaz proporcionada por Spring Data JPA que proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad Pelicula.
Pelicula: Especifica la entidad con la que este repositorio trabajará.
Integer: Especifica el tipo de la clave primaria de la entidad Pelicula (que es Integer para id_movie).



////////////////////////////////////////////////////////////////////////////////////////////////////////////



Versión 0.4.1: (Teatros Repository)

package com.Cine.Project.Movies_Reservation_Rico_Project;: Define el paquete de la clase. Asegúrate de que coincida con la estructura de tu proyecto.
import jakarta.persistence.*;: Importa las anotaciones necesarias de JPA.
import java.time.LocalDateTime;: Importa la clase para manejar la fecha y hora de creación.
@Entity: Marca la clase Teatro como una entidad JPA.
@Table(name = "teatros"): Especifica que esta entidad se mapea a la tabla llamada "teatros" en la base de datos.
@Id: Marca el campo id_theater como la clave primaria.
@GeneratedValue(strategy = GenerationType.IDENTITY): Configura la generación automática de la clave primaria (auto-incremento en MySQL).
@Column(nullable = false, length = 100): Define la columna name como no nula y con una longitud máxima de 100 caracteres.
@Column(nullable = false, length = 200): Define la columna location como no nula y con una longitud máxima de 200 caracteres.
@Column(nullable = false): Define la columna capacity como no nula.
@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"): Define la columna createdAt.
name = "created_at": Especifica el nombre de la columna en la base de datos.
columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP": Indica que el tipo de datos es TIMESTAMP y que, por defecto, se establecerá la fecha y hora actual al crear un nuevo registro.








Constructores:
El constructor sin argumentos (Teatro()) es necesario para JPA.
El constructor con argumentos permite crear instancias de Teatro con valores iniciales.
Getters y Setters: Proporcionan métodos para acceder y modificar los atributos de la clase.
///
package com.Cine.Project.Movies_Reservation_Rico_Project.repositories;: Define el paquete del repositorio.
import com.Cine.Project.Autor.Project.Teatro;: Importa la clase de entidad Teatro.
import org.springframework.data.jpa.repository.JpaRepository;: Importa la interfaz JpaRepository de Spring Data JPA.
import org.springframework.stereotype.Repository;: Importa la anotación @Repository de Spring.
@Repository: Marca la interfaz como un componente de repositorio en Spring.
public interface TeatroRepository extends JpaRepository<Teatro, Integer>: Declara la interfaz TeatroRepository que extiende JpaRepository. Esto proporciona los métodos básicos para realizar operaciones CRUD en la entidad Teatro, utilizando Integer como el tipo de la clave primaria.



////////////////////////////////////////////////////////////////////////////////////////////////////////////





Versión 0.5.1: (Horarios Repository)
package com.Cine.Project.Movies_Reservation_Rico_Project;: Define el paquete.
import jakarta.persistence.*;: Importa las anotaciones JPA.
import java.time.LocalDate;: Importa LocalDate para representar la fecha de proyección (sin tiempo)
import java.time.LocalTime;: Importa LocalTime para representar la hora de proyección (sin fecha).
import java.time.LocalDateTime;: Importa LocalDateTime para la fecha y hora de creación.
@Entity: Marca la clase como entidad JPA.
@Table(name = "Horarios"): ¡Importante! Especifica el nombre de la tabla como "Horarios" para que coincida exactamente con el nombre que definiste en tu esquema de base de datos.
@Id y @GeneratedValue: Definen id_showtime como clave primaria auto-incrementable.
@ManyToOne y @JoinColumn (para pelicula):
@ManyToOne: Indica una relación "muchos a uno" desde Horario hacia Pelicula. Muchos horarios pueden corresponder a una misma película.
@JoinColumn(name = "id_movie", nullable = false): Especifica la columna de clave foránea en la tabla Horarios que referencia a la tabla peliculas.
name = "id_movie": El nombre de la columna de clave foránea en la tabla Horarios es id_movie.
nullable = false: Indica que esta columna no puede ser nula (un horario siempre debe estar asociado a una película).
private Pelicula pelicula;: Define un atributo pelicula de tipo Pelicula para representar la relación.
@ManyToOne y @JoinColumn (para teatro): Similar a la relación con Pelicula, define una relación "muchos a uno" con la entidad Teatro usando la columna de clave foránea id_theater.
@Column(nullable = false) (para show_date): Define la columna show_date como no nula. Usamos LocalDate para representar solo la fecha.
@Column(nullable = false) (para show_time): Define la columna show_time como no nula. Usamos LocalTime para representar solo la hora.
@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"): Define la columna createdAt con tipo TIMESTAMP y valor por defecto CURRENT_TIMESTAMP.
Constructores y Getters/Setters: Generados de manera estándar.

(Horarios Repository)
Similar a los repositorios anteriores, extiende JpaRepository para heredar los métodos CRUD básicos para la entidad Horario, utilizando Integer como tipo de la clave primaria.

Versión 0.2.1.1: (Inicio Servicios - Creacion de TeatroService y TeatroServiceImpl )
UserService: Para la lógica de negocio relacionada con los usuarios (crear usuarios, obtener usuarios, actualizar información de usuarios, etc.).
PeliculaService: Para la lógica de negocio relacionada con las películas (crear películas, obtener películas, buscar películas, etc.).
TeatroService: Para la lógica de negocio relacionada con los teatros.
HorarioService: Para la lógica de negocio relacionada con los horarios de proyección.
ReservaService: Para la lógica de negocio relacionada con las reservas.

Versión 0.2.2.1: (Se crean los servicios de Pelicula)
(Documentacion en la 0.2.4.1)
Versión 0.2.3.1: (Se crean los servicios de Horarios)
(Documentacion en la 0.2.4.1 Reserva)
Versión 0.2.4.1: (Se crean los servicios de Reserva (y se documenta todo))

la capa de servicios en la arquitectura de tu proyecto actúa como una capa intermedia entre los controladores (Controllers) y los repositorios (Repositories). Su principal responsabilidad es encapsular y gestionar la lógica de negocio de la aplicación. En lugar de que los controladores o los repositorios contengan la lógica compleja, los servicios se encargan de:
Implementar las reglas y validaciones específicas del negocio.
Coordinar las operaciones entre diferentes entidades y repositorios si es necesario.
Proporcionar una interfaz clara y cohesiva para que los controladores accedan a la funcionalidad del backend.
1. UserService y UserServiceImpl
UserService (Interfaz): Define las operaciones de negocio relacionadas con la entidad User (Usuario).
crearUsuario(User usuario): Crea un nuevo usuario en el sistema.
obtenerUsuarioPorId(Integer id): Recupera un usuario por su identificador único (ID).

obtenerUsuarioPorEmail(String email): Recupera un usuario por su dirección de correo electrónico.
listarTodosLosUsuarios(): Recupera una lista de todos los usuarios registrados en el sistema.
actualizarUsuario(Integer id, User usuarioActualizado): Actualiza la información de un usuario existente.
eliminarUsuario(Integer id): Elimina un usuario del sistema por su ID.
UserServiceImpl (Implementación): Implementa la interfaz UserService.
@Service: Anotación de Spring que marca esta clase como un componente de servicio, permitiendo la inyección de dependencias.
@Autowired private final UserRepository userRepository;: Inyecta una instancia de UserRepository para acceder a la capa de datos de usuarios.
crearUsuario(User usuario): Utiliza userRepository.save(usuario) para persistir un nuevo usuario en la base de datos. Podría contener validaciones adicionales antes de guardar (no implementado aún).
obtenerUsuarioPorId(Integer id): Utiliza userRepository.findById(id) para buscar y retornar un usuario por su ID.
obtenerUsuarioPorEmail(String email): Implementación INCOMPLETA (Ejemplo): Actualmente, solo retorna un usuario ficticio. Deberá implementarse la búsqueda real por email (posiblemente con un método personalizado en UserRepository).
listarTodosLosUsuarios(): Utiliza userRepository.findAll() para obtener y retornar una lista de todos los usuarios.
actualizarUsuario(Integer id, User usuarioActualizado):
Recupera el usuario existente por ID usando userRepository.findById(id).
Si existe, actualiza los campos modificables del usuario existente con los valores de usuarioActualizado.
Guarda el usuario actualizado con userRepository.save(usuarioExistente).
eliminarUsuario(Integer id):
Verifica si el usuario existe usando userRepository.existsById(id).
Si existe, elimina el usuario usando userRepository.deleteById(id).
2. TeatroService y TeatroServiceImpl
TeatroService (Interfaz): Define las operaciones de negocio para la entidad Teatro.
crearTeatro(Teatro teatro): Crea un nuevo teatro.
obtenerTeatroPorId(Integer id): Obtiene un teatro por su ID.
listarTodosLosTeatros(): Obtiene una lista de todos los teatros.
actualizarTeatro(Integer id, Teatro teatroActualizado): Actualiza la información de un teatro existente.
eliminarTeatro(Integer id): Elimina un teatro por su ID.
TeatroServiceImpl (Implementación): Implementa TeatroService.
@Service: Componente de servicio de Spring.
@Autowired private final TeatroRepository teatroRepository;: Inyecta TeatroRepository.
Métodos (similar a UserServiceImpl): Cada método implementa la lógica correspondiente utilizando los métodos CRUD del TeatroRepository (save, findById, findAll, deleteById, existsById). La lógica de actualización se encarga de recuperar el teatro existente, actualizar los campos permitidos (nombre, ubicación, capacidad) y guardar los cambios.
3. PeliculaService y PeliculaServiceImpl
PeliculaService (Interfaz): Define las operaciones de negocio para la entidad Pelicula.
crearPelicula(Pelicula pelicula): Crea una nueva película.
obtenerPeliculaPorId(Integer id): Obtiene una película por su ID.
listarTodasLasPeliculas(): Obtiene una lista de todas las películas.
actualizarPelicula(Integer id, Pelicula peliculaActualizada): Actualiza la información de una película existente.
eliminarPelicula(Integer id): Elimina una película por su ID.
PeliculaServiceImpl (Implementación): Implementa PeliculaService.
@Service: Componente de servicio de Spring.
@Autowired private final PeliculaRepository peliculaRepository;: Inyecta PeliculaRepository.
Métodos (similar a UserServiceImpl): Implementa la lógica utilizando PeliculaRepository para operaciones CRUD sobre películas. La actualización permite modificar título, descripción, duración y lenguaje.
4. HorarioService y HorarioServiceImpl
HorarioService (Interfaz): Define las operaciones de negocio para la entidad Horario.
crearHorario(Horario horario): Crea un nuevo horario de proyección.
obtenerHorarioPorId(Integer id): Obtiene un horario por su ID.
listarTodosLosHorarios(): Obtiene una lista de todos los horarios.
actualizarHorario(Integer id, Horario horarioActualizado): Actualiza la información de un horario existente.
eliminarHorario(Integer id): Elimina un horario por su ID.
HorarioServiceImpl (Implementación): Implementa HorarioService.
@Service: Componente de servicio de Spring.
@Autowired private final HorarioRepository horarioRepository;: Inyecta HorarioRepository.
Métodos (similar a UserServiceImpl): Implementa la lógica utilizando HorarioRepository para operaciones CRUD sobre horarios. La actualización permite modificar la película, el teatro, la fecha y la hora de proyección.
5. ReservaService y ReservaServiceImpl
ReservaService (Interfaz): Define las operaciones de negocio para la entidad Reserva.
crearReserva(Reserva reserva): Crea una nueva reserva.
obtenerReservaPorId(Integer id): Obtiene una reserva por su ID.
listarTodasLasReservas(): Obtiene una lista de todas las reservas.
actualizarReserva(Integer id, Reserva reservaActualizada): Actualiza la información de una reserva existente.
eliminarReserva(Integer id): Elimina una reserva por su ID.
ReservaServiceImpl (Implementación): Implementa ReservaService.
@Service: Componente de servicio de Spring.
@Autowired private final ReservaRepository reservaRepository;: Inyecta ReservaRepository.
Métodos (similar a UserServiceImpl): Implementa la lógica utilizando ReservaRepository para operaciones CRUD sobre reservas. La actualización permite modificar el horario, el usuario, el número de tickets y el precio total de la reserva.

