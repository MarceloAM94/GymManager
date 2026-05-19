package gym.model;

import java.time.LocalDate;
import java.util.UUID;

public class Membresia {

    private UUID id;
    private UUID clienteId;
    private TipoMembresia tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoMembresia estado;

    public Membresia(UUID id, UUID clienteId, TipoMembresia tipo, LocalDate fechaInicio, LocalDate fechaFin, EstadoMembresia estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Membresia(UUID clienteId, TipoMembresia tipo, LocalDate fechaInicio){
        this.id = UUID.randomUUID();
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.estado = EstadoMembresia.ACTIVA; //Toda membresia empieza activa

        //Calulo de vigencia
        if(tipo == TipoMembresia.MENSUAL){
            this.fechaFin = fechaInicio.plusMonths(1);
        } else if (tipo == TipoMembresia.TRIMESTRAL) {
            this.fechaFin = fechaInicio.plusMonths(3);
        } else if (tipo == TipoMembresia.ANUAL) {
            this.fechaFin = fechaInicio.plusMonths(12);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public TipoMembresia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMembresia tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EstadoMembresia estado) {
        this.estado = estado;
    }
}
