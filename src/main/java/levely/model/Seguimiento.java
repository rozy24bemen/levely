package levely.model;

import jakarta.persistence.*;
import java.time.Instant;
import levely.model.keys.SeguimientoId;

@Entity
@Table(name = "seguimientos")
public class Seguimiento {
    @EmbeddedId
    private SeguimientoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("seguidorId")
    @JoinColumn(name = "seguidor_id")
    private Usuario seguidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("seguidoId")
    @JoinColumn(name = "seguido_id")
    private Usuario seguido;

    @Column(name = "fecha_seguimiento")
    private Instant fechaSeguimiento;

    public Seguimiento() {}

    public SeguimientoId getId() { return id; }
    public void setId(SeguimientoId id) { this.id = id; }
    public Usuario getSeguidor() { return seguidor; }
    public void setSeguidor(Usuario seguidor) { this.seguidor = seguidor; }
    public Usuario getSeguido() { return seguido; }
    public void setSeguido(Usuario seguido) { this.seguido = seguido; }
    public Instant getFechaSeguimiento() { return fechaSeguimiento; }
    public void setFechaSeguimiento(Instant fechaSeguimiento) { this.fechaSeguimiento = fechaSeguimiento; }
}
