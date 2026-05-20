package gym.repository;

import gym.model.Rutina;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RutinaRepository {
    void guardar(Rutina rutina);
    Optional<Rutina> buscarPorId(UUID id);
    List<Rutina> buscarPorClienteId(UUID clienteId);
    List<Rutina> listarTodas();
}
