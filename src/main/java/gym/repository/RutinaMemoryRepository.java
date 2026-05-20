package gym.repository;

import gym.model.Rutina;

import java.util.*;

public class RutinaMemoryRepository implements RutinaRepository{
    private final Map<UUID, Rutina> datasource = new HashMap<>();

    @Override
    public void guardar(Rutina rutina) {
        if (rutina == null || rutina.getId() == null ){
            throw new IllegalArgumentException("No se puede guardar una rutina nula o son ID valido.");
        }
        datasource.put(rutina.getId(), rutina);
    }

    @Override
    public Optional<Rutina> buscarPorId(UUID id) {
        return Optional.ofNullable(datasource.get(id));
    }

    @Override
    public List<Rutina> buscarPorClienteId(UUID clienteId) {
        if (clienteId == null) return Collections.emptyList();

        // Filtramos todas las rutinas que pertenezcan a ese cliente y las agrupamos en una Lista
        return datasource.values().stream()
                .filter(rutina -> clienteId.equals(rutina.getClienteId()))
                .toList(); // Cambiado para devolver todas las rutinas del cliente
    }

    @Override
    public List<Rutina> listarTodas() {
        return new ArrayList<>(datasource.values());
    }
}
