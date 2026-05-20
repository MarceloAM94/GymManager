package gym.service;

import gym.model.Pago;

public class TarjetaProcesador implements ProcesadorPago{
    @Override
    public boolean procesar(Pago pago) {
        System.out.println("Conectando con la pasarela de tarjetas para el monto: S/. " + pago.getMonto());
        if (pago.getMonto() > 500.0){
            System.out.println("Transaccion rechazada por el banco: Limite excedido");
            return false;
        }
        return true;
    }
}
