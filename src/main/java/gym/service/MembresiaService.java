package gym.service;
import gym.model.TipoMembresia;
import java.util.*;

public interface MembresiaService {
    void asignarMembresia(UUID clienteId, TipoMembresia tipo);
    void verificarYActualizarEstado();
}
