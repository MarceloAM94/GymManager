package gym.service;
import gym.model.Cliente;
import gym.model.EstadoMembresia;
import gym.model.Membresia;
import gym.model.TipoMembresia;
import gym.model.Usuario;
import gym.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.UUID;

public class MembresiaServiceImpl implements MembresiaService{

    private final UsuarioRepository usuarioRepository;

    public MembresiaServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void asignarMembresia(UUID clienteId, TipoMembresia tipo) {
        //Buscamos usuario en el repositorio usando Optional
        Usuario usuario = usuarioRepository.buscarPorId(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Error: El usuario con ID " + clienteId + " no existe."));

        //Validad que el usuario sea realmente un cliente
        if(!(usuario instanceof Cliente)){
            throw new IllegalArgumentException("Error: El ID proporcionado no pertenece a un cliente.");
        }

        Cliente cliente = (Cliente) usuario;

        //Crear membresia usando el constructor que calcula de la fechaFin
        Membresia nuevaMembresia = new Membresia(clienteId, tipo, LocalDate.now());

        //Asociar la membresia al cliente y asegurar que el cliente este activo
        cliente.setMembresiaActiva(nuevaMembresia);
        cliente.setActivo(true);

        //Guardar los cambios en el repositorio
        usuarioRepository.guardar(cliente);
        System.out.println("Membresia " + tipo + " asignada con exito al cliente: " + cliente.getName());
    }

    @Override
    public void verificarYActualizarEstado() {
        LocalDate hoy = LocalDate.now();
        System.out.println("=== Iniciando verificacion programada de membresias (" + hoy + ") ===)");

        //Recorremos los usuarios, filtramos los clientes y tienen membresia
        usuarioRepository.listarTodos().stream()
                .filter(usuario -> usuario instanceof Cliente)
                .map(usuario -> (Cliente) usuario)
                .filter(cliente -> cliente.getMembresiaActiva() != null)
                .forEach(cliente -> {
                    Membresia membresia = cliente.getMembresiaActiva();

                    //Si la fecha de fin es anterior a hoy se cambia a vencido
                    if (membresia.getFechaFin().isBefore(hoy) && membresia.getEstado() == EstadoMembresia.ACTIVA) {
                        cliente.setActivo(false);
                        usuarioRepository.guardar(cliente);
                        System.out.println("La membresia de " + cliente.getName() + " ha expirado. Estado cambiado a INACTIVO.");
                    }
                });
        System.out.println("=== Verificacion de membresias finalizada ===");
    }
}
