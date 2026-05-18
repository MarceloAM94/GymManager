package gym.repository;
import gym.model.Usuario;
import java.util.*;

public class UsuarioMemoryRepository implements UsuarioRepository{

    private final Map<UUID, Usuario> datasource = new HashMap<>();

    @Override
    public void guardar(Usuario usuario) {
        if (usuario == null || usuario.getId() == null){
            throw new IllegalArgumentException("No se puede guardar un usuario nulo o sin ID legitimo.");
        }
        datasource.put(usuario.getId(), usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(UUID id) {
        return Optional.ofNullable(datasource.get(id));
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        if (email == null) return Optional.empty();

        return datasource.values().stream()
                .filter(usuario -> email.equalsIgnoreCase(usuario.getEmail()))
                .findFirst();
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(datasource.values());
    }

    @Override
    public void eliminar(UUID id) {
        datasource.remove(id);
    }
}
