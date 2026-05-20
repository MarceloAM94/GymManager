package gym.service;

import gym.model.Pago;

public interface ProcesadorPago {
    boolean procesar(Pago pago);
}
