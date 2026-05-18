package gym.model;
import java.time.LocalDate;
import java.util.UUID;

public class Cliente extends Usuario{

    private LocalDate fechaInscripcion;
    private boolean activo;

    public Cliente(UUID id, String name, String email, String password, LocalDate fechaInscripcion, boolean activo) {
        super(id, name, email, password, Rol.CLIENTE);
        this.fechaInscripcion = fechaInscripcion;
        this.activo = activo;
    }

    public Cliente(String name, String email, String password, LocalDate fechaInscripcion) {
        super(UUID.randomUUID(), name, email, password, Rol.CLIENTE);
        this.fechaInscripcion = fechaInscripcion;
        this.activo = true; // Todo cliente nuevo inicia activo por defecto
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
