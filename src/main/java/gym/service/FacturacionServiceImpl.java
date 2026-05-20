package gym.service;

import gym.model.EstadoPago;
import gym.model.Pago;
import gym.repository.UsuarioRepository;

import java.util.UUID;

public class FacturacionServiceImpl implements FacturacionService{
    private final UsuarioRepository usuarioRepository;

    public FacturacionServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Pago registrarCobroMembresia(UUID clienteId, double monto, String metodo) {
        usuarioRepository.buscarPorId(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("El cliente no existe."));

        Pago pago = new Pago(clienteId, monto, metodo);

        ProcesadorPago procesador;
        if("TARJETA".equalsIgnoreCase(metodo)){
            procesador = new TarjetaProcesador();
        }else{
            procesador = new EfectivoProcesador();
        }

        boolean exito = procesador.procesar(pago);

        if(exito){
            pago.setEstado(EstadoPago.PROCESADO);
            System.out.println("Pago registrado exitosamente. ID: " + pago.getId());
        }else{
            pago.setEstado(EstadoPago.RECHAZADO);
            System.out.println("El pago no pudo ser procesado.");
        }

        return pago;
    }
}
