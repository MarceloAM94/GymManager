package gym.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Administrador extends Usuario {

    private String nivelAcceso; // Ejemplo: "SUPER_ADMIN", "MODERADOR"
    private LocalDateTime ultimoIngreso;

    // Constructor completo para cuando creamos o cargamos el Admin
    public Administrador(UUID id, String name, String email, String password, String nivelAcceso) {
        super(id, name, email, password, Rol.ADMIN); // Setea el rol automáticamente
        this.nivelAcceso = nivelAcceso;
        this.ultimoIngreso = LocalDateTime.now(); // Por defecto, se inicializa con la hora actual
    }

    // Constructor secundario
    public Administrador(String name, String email, String password, String nivelAcceso) {
        super(UUID.randomUUID(), name, email, password, Rol.ADMIN);
        this.nivelAcceso = nivelAcceso;
    }

    // Getters y Setters
    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public LocalDateTime getUltimoIngreso() {
        return ultimoIngreso;
    }

    public void setUltimoIngreso(LocalDateTime ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }
}