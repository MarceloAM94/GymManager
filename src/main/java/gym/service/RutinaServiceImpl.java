package gym.service;

import gym.model.Cliente;
import gym.model.Ejercicio;
import gym.model.Entrenador;
import gym.model.Rutina;
import gym.model.Usuario;
import gym.repository.RutinaRepository;
import gym.repository.UsuarioRepository;

import java.util.List;
import java.util.UUID;

public class RutinaServiceImpl implements RutinaService {

    // Inyección de dependencias por constructor
    private final RutinaRepository rutinaRepository;
    private final UsuarioRepository usuarioRepository;

    public RutinaServiceImpl(RutinaRepository rutinaRepository, UsuarioRepository usuarioRepository) {
        this.rutinaRepository = rutinaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UUID crearRutinaNueva(String nombre, UUID entrenadorId, UUID clienteId) {
        Usuario entrenador = usuarioRepository.buscarPorId(entrenadorId)
                .orElseThrow(() -> new IllegalArgumentException("Error: El entrenador con ID " + entrenadorId + " no existe."));

        if (!(entrenador instanceof Entrenador)) {
            throw new IllegalArgumentException("Error: El ID de entrenador proporcionado no pertenece a un Entrenador registrado.");
        }

        Usuario cliente = usuarioRepository.buscarPorId(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Error: El cliente con ID " + clienteId + " no existe."));

        if (!(cliente instanceof Cliente)) {
            throw new IllegalArgumentException("Error: El ID de cliente proporcionado no pertenece a un Cliente registrado.");
        }

        Rutina nuevaRutina = new Rutina(nombre, entrenadorId, clienteId);

        rutinaRepository.guardar(nuevaRutina);
        System.out.println("✨ Rutina '" + nombre + "' creada con éxito por el Entrenador " + entrenador.getName() + " para el Cliente " + cliente.getName());

        return nuevaRutina.getId();
    }

    @Override
    public void agregarEjercicioARutina(UUID rutinaId, Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new IllegalArgumentException("No se puede agregar un ejercicio nulo.");
        }

        Rutina rutina = rutinaRepository.buscarPorId(rutinaId)
                .orElseThrow(() -> new IllegalArgumentException("Error: La rutina con ID " + rutinaId + " no existe."));

        rutina.agregarEjercicio(ejercicio);

        rutinaRepository.guardar(rutina);
        System.out.println("💪 Ejercicio '" + ejercicio.getNombre() + "' agregado a la rutina: " + rutina.getNombre());
    }

    @Override
    public List<Rutina> obtenerRutinasDeCliente(UUID clienteId) {
        // Validamos primero si el cliente existe en el sistema
        if (!usuarioRepository.buscarPorId(clienteId).isPresent()) {
            throw new IllegalArgumentException("Error: El cliente con ID " + clienteId + " no existe.");
        }

        return rutinaRepository.buscarPorClienteId(clienteId);
    }
}