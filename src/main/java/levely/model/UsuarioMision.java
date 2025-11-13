package levely.model;

import jakarta.persistence.*;
import java.time.Instant;
import levely.model.keys.UsuarioMisionId;

@Entity
@Table(name = "usuarios_misiones")
public class UsuarioMision {
    @EmbeddedId
    private UsuarioMisionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("misionId")
    @JoinColumn(name = "mision_id")
    private Mision mision;

    @Column(name = "fecha_completado")
    private Instant fechaCompletado;

    public UsuarioMision() {}

    public UsuarioMisionId getId() { return id; }
    public void setId(UsuarioMisionId id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Mision getMision() { return mision; }
    public void setMision(Mision mision) { this.mision = mision; }
    public Instant getFechaCompletado() { return fechaCompletado; }
    public void setFechaCompletado(Instant fechaCompletado) { this.fechaCompletado = fechaCompletado; }
}
