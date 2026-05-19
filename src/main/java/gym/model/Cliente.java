package gym.model;
import java.time.LocalDate;
import java.util.UUID;

public class Cliente extends Usuario{

    private LocalDate fechaInscripcion;
    private boolean activo;
    private Membresia membresiaActiva;

    public Cliente(UUID id, String name, String email, String password, LocalDate fechaInscripcion, boolean activo) {
        super(id, name, email, password, Rol.CLIENTE);
        this.fechaInscripcion = fechaInscripcion;
        this.activo = activo;
        this.membresiaActiva = null;
    }

    public Cliente(String name, String email, String password, LocalDate fechaInscripcion) {
        super(UUID.randomUUID(), name, email, password, Rol.CLIENTE);
        this.fechaInscripcion = fechaInscripcion;
        this.activo = true; // Todo cliente nuevo inicia activo por defecto
        this.membresiaActiva = null;
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

    public Membresia getMembresiaActiva() {
        return membresiaActiva;
    }

    public void setMembresiaActiva(Membresia membresiaActiva) {
        this.membresiaActiva = membresiaActiva;
    }
}
