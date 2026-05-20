package gym.service;

import gym.model.Pago;

import java.util.UUID;

public interface FacturacionService {
    Pago registrarCobroMembresia(UUID clienteId, double monto, String metodo);
}
