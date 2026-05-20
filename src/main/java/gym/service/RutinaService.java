package gym.service;

import gym.model.Ejercicio;
import gym.model.Rutina;
import java.util.List;
import java.util.UUID;

public interface RutinaService {
    UUID crearRutinaNueva(String nombre, UUID entrenadorId, UUID clienteId);
    void agregarEjercicioARutina(UUID rutinaId, Ejercicio ejercicio);
    List<Rutina> obtenerRutinasDeCliente(UUID clienteId);
}