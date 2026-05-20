package gym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rutina {

    private UUID id;
    private String nombre;
    private UUID entrenadorId;
    private UUID clienteId;
    private List<Ejercicio> ejercicios;

    public Rutina(String nombre, UUID entrenadorId, UUID clienteId) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.entrenadorId = entrenadorId;
        this.clienteId = clienteId;
        this.ejercicios = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UUID getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(UUID entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void agregarEjercicio(Ejercicio ejercicio){
        this.ejercicios.add(ejercicio);
    }
}
