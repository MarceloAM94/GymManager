package gym.service;

import gym.model.Pago;

public class EfectivoProcesador implements ProcesadorPago{
    @Override
    public boolean procesar(Pago pago) {
        System.out.println("Procesando pago en efectivo de S/. " + pago.getMonto());
        return true;
    }
}
