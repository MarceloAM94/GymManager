package gym.model;

import java.util.UUID;

public class Entrenador extends Usuario{

    private String especialidad;
    private String turno;

    public Entrenador(UUID id, String name, String email, String password, String especialidad, String turno) {
        super(id, name, email, password, Rol.ENTRENADOR);
        this.especialidad = especialidad;
        this.turno = turno;
    }

    public Entrenador(String name, String email, String password, String especialidad, String turno) {
        super(UUID.randomUUID(), name, email, password, Rol.ENTRENADOR);
        this.especialidad = especialidad;
        this.turno = turno;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
