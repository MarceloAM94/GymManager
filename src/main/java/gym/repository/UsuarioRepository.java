package gym.repository;
import gym.model.Usuario;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository { // <-- Cambiado de class a interface

    void guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(UUID id);
    Optional<Usuario> buscarPorEmail(String email);
    List<Usuario> listarTodos();
    void eliminar(UUID id);
}
